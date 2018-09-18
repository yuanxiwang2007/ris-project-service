package com.rms.risproject.util;

import java.util.Calendar;

public class Constant {

    private static final int MACID_LENGTH=16;
    public static final int SESSION_OVERTIME_MINUTES =30;
    public static final int QR_OVERTIME_SECONDS =3*24*60*60; //3天 以秒为单位
    public static final String URINE_WX_INTERFACE_SCENECODE="20";
    //机器码BFEBFBFF000306A9
    public static String subString4MacID(String token){
        return token.substring(0,MACID_LENGTH);
    }

    //时间戳1500552871000
    public static Long subString4Datetime(String token){
        return Long.parseLong(token.substring(MACID_LENGTH));
    }

    /**
     * @param
     * @return
     */
    public static boolean isOvertime(Long datetime) {
        Calendar cal =Calendar.getInstance();
        cal.setTimeInMillis(datetime);
        cal.add(Calendar.MINUTE, SESSION_OVERTIME_MINUTES);
        Calendar calNow =Calendar.getInstance();
        if(calNow.after(cal)){ //超时
            return true;
        }
        return false;
    }
}
