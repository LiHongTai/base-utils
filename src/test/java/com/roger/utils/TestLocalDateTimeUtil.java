package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestLocalDateTimeUtil extends TestCase {

    @Test
    public void testNowToystem(){
        System.out.println(LocalDateTimeUtil.nowToSystem());
    }

    @Test
    public void testNowToystemWithPattern(){
        System.out.println(LocalDateTimeUtil.nowToSystem("HH:mm:ss"));
    }

    @Test
    public void testStrToLocalDateTime(){
        String str = "2018-09-25 10:59:23";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTimeUtil.strToLocalDateTime(str,pattern);
    }
}
