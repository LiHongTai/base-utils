package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClassUtilTest extends TestCase {

    @Test
    public void testGetClasses() throws Exception{

        ArrayList<Class<?>> classes = ClassUtil.getClasses("com");

        for (Class clazz : classes){
            System.out.println(clazz);
            System.out.println(clazz.getName());
            System.out.println("....");
        }
    }
}