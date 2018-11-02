package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestLocalDateUtil extends TestCase {

    @Test
    public void testNowToystem() {
        System.out.println(LocalDateUtil.nowToSystem());
    }

    @Test
    public void testNowToystemWithPattern() {
        System.out.println(LocalDateUtil.nowToSystem("yyyy-MM-dd"));
    }

    @Test
    public void testStrToLocalDateTime() {
        String str = "2018-09-23 10:59:23";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDate localDate = LocalDateUtil.strToLocalDate(str, pattern);
        System.out.println(localDate.toString());
    }


    @Test
    public void testAgoToToday() {
        String str = "2018-11-26";
        System.out.println(LocalDateUtil.agoToToady(str, "Day"));

        str = "2017-12-26";
        System.out.println(LocalDateUtil.agoToToady(str, "Year"));

        str = "2017-12-24";
        System.out.println(LocalDateUtil.agoToToady(str, "Month"));
    }
}
