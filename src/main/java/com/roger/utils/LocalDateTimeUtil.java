package com.roger.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取默认格式的系统当前时间（String类型）
     */
    public static String nowToSystem(){
        return nowToSystem(DEFAULT_DATE_TIME_FORMAT);
    }
    /**
     * 获取指定格式的系统当前时间（String类型）
     */
    public static String nowToSystem(String pattern){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return now.format(format);
    }

    /**
     *  按照默认格式把String转换成LocalDateTime类型的对象
     */
    public static LocalDateTime strToLocalDateTime(String str){
        return strToLocalDateTime(str,DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 根据指定格式把String转换成LocalDateTime类型的对象
     */
    public static LocalDateTime strToLocalDateTime(String str,String pattern){
        if(str == null || str.trim().equals("")){
            return null;
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(str,format);
    }

    /**
     *  按照默认格式把LocalDateTime转换成String类型的对象
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime){
        return localDateTimeToStr(localDateTime,DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 根据指定格式把LocalDateTime转换成String类型的对象
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime,String pattern){
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(format);
    }

}
