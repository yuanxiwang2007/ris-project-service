package com.rms.risproject.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EnChanger {

    private static Object getFieldValue(Object object, String fieldName) {

        //根据 对象和属性名通过取 Field对象
        Field field = getDeclaredField(object, fieldName);

        //抑制Java对其的检查
        field.setAccessible(true);
        try {
            //获的属性值
            return field.get(object);
        } catch (Exception e) {
            //logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 循环向上转型, 获     * @param object : 子类对象
     *
     * @param fieldName : 父类中     * @return 父类中
     */
    private static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;

        Class<?> clazz = object.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (NoSuchFieldException e) {
                //logger.debug("无此字段:{}", e.getMessage());
            } catch (Exception e) {
                //logger.error(e.getMessage());
            }
        }
        return null;
    }

    public static Object changeEn(Object object) {
        if (object != null && object instanceof List) {
            ((ArrayList) object).forEach((o) -> changeEn(o));
        } else if (object != null && object instanceof Map) {
            ((Map) object).forEach((k, v) -> changeEn(v));
        } else if (object != null && object instanceof Set) {
            ((Set) object).forEach((o) -> changeEn(o));
        } else {
            Field[] f = object.getClass().getDeclaredFields();
            //logger.debug("翻译时,检查的对象类型为:{}", object.getClass());
            for (Field origField : f) {
                origField.setAccessible(true);
                try {
                    Object origFieldObj = origField.get(object);
                    if (origFieldObj instanceof Set ||
                            origFieldObj instanceof Map) {
                        changeEn(origField.get(object));
                    } else if ((origFieldObj instanceof List || origField.getType() == List.class)
                            && !origField.getName().endsWith("En")
                            ) {
                        changeListEn(object, origFieldObj, origField);

                    } else if (origFieldObj instanceof String
                            && !origField.getName().endsWith("En")
                            && !"keyID".equals(origField.getName())) {
                        String enFiledName = origField.getName() + "En";
                        Field enFiled = getDeclaredField(object, enFiledName);
                        //logger.debug("正在尝试翻译字段:" + origField.getName());
                        if (enFiled != null) {
                            origField.set(object, getFieldValue(object, enFiledName));
                            //logger.debug("翻译{}字段成功!!", origField.getName());
                        }
                    }
                } catch (IllegalAccessException e) {
                    //logger.error(e.getMessage());
                }
            }
        }
        return object;
    }

    /**
     * 根据List<String> 做特殊处理
     *
     * @param object
     * @param origFieldObj
     * @param origField
     * @return
     * @throws IllegalAccessException
     */
    private static Object changeListEn(Object object, Object origFieldObj, Field origField) throws IllegalAccessException {
        ParameterizedType listGenericType = (ParameterizedType) origField.getGenericType();
        Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
        System.out.println(listActualTypeArguments[listActualTypeArguments.length - 1]);
        if (listActualTypeArguments[listActualTypeArguments.length - 1] == String.class) {
            String enFiledName = origField.getName() + "En";
            Field enFiled = getDeclaredField(object, enFiledName);
            //logger.debug("正在尝试翻译字段:" + origField.getName());
            if (enFiled != null) {
                origField.set(object, getFieldValue(object, enFiledName));
                //logger.debug("翻译{}字段成功!!", origField.getName());
            }
        } else if (origFieldObj != null) {
            changeEn(origField.get(object));
        }
        return object;

        //先判断中文是否为空 不为空
//        if (origFieldObj != null && ((ArrayList) origFieldObj).size() > 0) {
//            if (((ArrayList) origFieldObj).get(0) instanceof String) {
//                String enFiledName = origField.getName() + "En";
//                Field enFiled = getDeclaredField(object, enFiledName);
//                logger.debug("正在尝试翻译字段:" + origField.getName());
//                if (enFiled != null) {
//                    origField.set(object, getFieldValue(object, enFiledName));
//                    logger.debug("翻译{}字段成功!!", origField.getName());
//                }
//            } else {
//                changeEn(origField.get(object));
//            }
//        } else {
//            //先判断中文是否为空 为空无法获取泛型类型 转为根据英文获取泛型类型
//            String enFiledName = origField.getName() + "En";
//            Field enFiled = getDeclaredField(object, enFiledName);
//            if (enFiled != null) {
//                Object enObject = getFieldValue(object, enFiledName);
//                if (enObject != null && ((ArrayList) enObject).size() > 0 && ((ArrayList) enObject).get(0) instanceof String) {
//                    origField.set(object, enObject);
//                    logger.debug("翻译{}字段成功!!", origField.getName());
//                }
//
//            }
//        }
//        return object;
    }
}
