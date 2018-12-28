package com.rms.risproject.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@Component
public class MongodbDao<T> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveObjectValue(T obj) {
        mongoTemplate.save(obj);
    }
    public void updateObjectValueByPramarykey(T obj) throws NoSuchFieldException, IllegalAccessException {
        Field field=getDeclaredField(obj,"keyId");
        field.setAccessible(true);
        Object value= field.get(obj);
        Query query = new Query(Criteria.where("keyId").is(value));
        Update update = new Update();
        update.set("name", 1);
        update.set("phoneNo", "123123123");
        mongoTemplate.updateFirst(query, update, obj.getClass());
    }
    public List<T> getObjectValue(Class<T> classs) {
        Query query = new Query();
        Criteria criteria = Criteria.where("isDeleted").is(0);
        query.addCriteria(criteria);
        List<T> list = mongoTemplate.find(query, classs);
        return list;
    }
    private Field getDeclaredField(Object object, String fieldName) {
        Field field = null;

        Class<?> clazz = object.getClass();

        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (NoSuchFieldException e) {
                logger.debug("无此字段:{}", e.getMessage());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return null;
    }
}
