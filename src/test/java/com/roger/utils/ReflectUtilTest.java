package com.roger.utils;

import com.roger.serialize.common.FDateJsonDeserializer;
import junit.framework.TestCase;
import org.junit.Test;

public class ReflectUtilTest extends TestCase {

    @Test
    public void testGetObject() {
        FDateJsonDeserializer fDateJsonDeserializer = new FDateJsonDeserializer();

        System.out.println(ReflectUtil.getObject(fDateJsonDeserializer,"fmt").getClass());

    }
}