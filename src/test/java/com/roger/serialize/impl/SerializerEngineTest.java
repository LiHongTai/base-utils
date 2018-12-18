package com.roger.serialize.impl;

import com.alibaba.fastjson.JSONObject;
import com.roger.serialize.ISerializer;
import com.roger.serialize.model.User;
import com.roger.utils.DateUtil;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SerializerEngineTest extends TestCase {

    private ISerializer iSerializer = null;

    @Before
    public void setUp(){
        //测试Hessian序列化
        //iSerializer  = new HessianSerializer();
        //测试Java序列化
        //iSerializer  = new JavaSerializer();
        //测试Xml序列化
        //iSerializer  = new XmlSerializer();
        //测试JSON序列化
        //iSerializer  = new JSONSerializer();
        //测试ProtoStuff序列化
        //iSerializer = new ProtoStuffSerializer();
        iSerializer = new MarshallingSerializer();
    }

    @Test
    public void testJavaBeanSerialize() {
        User user = new User();
        user.setId(1L);
        user.setName("Roger");
        user.setAge(12);
        user.setBirthDate(DateUtil.parse("1988-06-18", "yyyy-MM-dd"));

        byte[] serializeObj = iSerializer.serialize(user);
        System.out.println(serializeObj);

        User deserializeObj = iSerializer.deserialize(serializeObj, User.class);
        System.out.println("JavaBean对象：" + deserializeObj);
    }

    @Test
    public void testStringSerialize() {
        String str = "I'm a String Object.";
        byte[] serializeObj = iSerializer.serialize(str);
        System.out.println(serializeObj);

        String deserializeObj = iSerializer.deserialize(serializeObj, String.class);
        System.out.println("String对象：" + deserializeObj);
    }

    @Test
    public void testMapSerialize() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "Roger");
        userMap.put("age", 13);
        byte[] serializeObj = iSerializer.serialize(userMap);
        System.out.println(serializeObj);

        Map deserializeObj = iSerializer.deserialize(serializeObj, HashMap.class);
        System.out.println("Map对象：" + deserializeObj);
    }

    @Test
    public void testJsonObjectSerialize() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Mary");
        jsonObject.put("birthDate",
                DateUtil.parse("1990-06-25", "yyyy-MM-dd"));
        byte[] serializeObj = iSerializer.serialize(jsonObject);
        System.out.println(serializeObj);

        JSONObject deserializeObj = iSerializer.deserialize(serializeObj, JSONObject.class);
        System.out.println("JSONObject对象：" + deserializeObj);
    }

}