package com.roger.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LocalDateUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 获取默认格式的系统当前时间（String类型）
     */
    public static String nowToSystem() {
        return nowToSystem(DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取指定格式的系统当前时间（String类型）
     */
    public static String nowToSystem(String pattern) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return now.format(format);
    }

    /**
     * 按照默认格式把String转换成LocalDate类型的对象
     */
    public static LocalDate strToLocalDate(String str) {
        return strToLocalDate(str, DEFAULT_DATE_FORMAT);
    }

    /**
     * 根据指定格式把String转换成LocalDate类型的对象
     */
    public static LocalDate strToLocalDate(String str, String pattern) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(str, format);
    }

    /**
     * 按照默认格式把LocalDate转换成String类型的对象
     */
    public static String localDateToStr(LocalDate localDate) {
        return localDateToStr(localDate, DEFAULT_DATE_FORMAT);
    }

    /**
     * 根据指定格式把LocalDate转换成String类型的对象
     */
    public static String localDateToStr(LocalDate localDate, String pattern) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(format);
    }

    /**
     * 计算从当前时间算起,距离str给定时间的天数，月数，或者年数
     *      负值表示str代表的是过去时间
     *      正值表示str代表是将来的时间
     */
    public static int agoToToady(String str, String type) {
        LocalDate agoLocalDate = strToLocalDate(str);
        return agoToToady(agoLocalDate, type);
    }

    public static int agoToToady(LocalDate agoLocalDate, String type) {
        LocalDate today = LocalDate.now();
        Period periodToNextBetweenJavaRelease = Period.between(today, agoLocalDate);

        int numYear = periodToNextBetweenJavaRelease.getYears();
        int memMonth = periodToNextBetweenJavaRelease.getMonths();
        int numDay = periodToNextBetweenJavaRelease.getDays();

        if ("Year".equals(type)) {
            return numYear;
        }

        if ("Month".equals(type)) {
            return numYear * 12 + memMonth;
        }

        if ("Day".equals(type)) {
            return calNumDayDateBetween(agoLocalDate,today);
        }
        throw new RuntimeException("请输入正确的类型参数");
    }

    private static int calNumDayDateBetween(LocalDate agoLocalDate,LocalDate today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(localDateToDate(agoLocalDate));
        long agoTime = calendar.getTimeInMillis();
        calendar.setTime(localDateToDate(today));
        long todayTime = calendar.getTimeInMillis();

        long beetweenDays = (todayTime - agoTime)/(1000*60*60*24);
        return Integer.parseInt(String.valueOf(beetweenDays));
    }

    public static Date localDateToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

}
