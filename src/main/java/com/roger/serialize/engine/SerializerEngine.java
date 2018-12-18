package com.roger.serialize.engine;

import com.roger.serialize.ISerializer;
import com.roger.serialize.enumeration.SerializerType;
import com.roger.serialize.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SerializerEngine {

    public static final Map<SerializerType, ISerializer> serializerMap = new ConcurrentHashMap<>();

    static {
        serializerMap.put(SerializerType.JavaSerializer, new JavaSerializer());
        serializerMap.put(SerializerType.HessianSerializer, new HessianSerializer());
        serializerMap.put(SerializerType.JSONSerializer, new JSONSerializer());
        serializerMap.put(SerializerType.XmlSerializer, new XmlSerializer());
        serializerMap.put(SerializerType.ProtoStuffSerializer, new ProtoStuffSerializer());
        serializerMap.put(SerializerType.MarshallingSerializer, new MarshallingSerializer());
    }


    public static <T> byte[] serialize(T obj, String serializeType) {
        SerializerType serialize = SerializerType.queryByType(serializeType);
        if (serialize == null) {
            throw new RuntimeException("serialize is null");
        }

        ISerializer serializer = serializerMap.get(serialize);
        if (serializer == null) {
            throw new RuntimeException("serialize error");
        }

        try {
            return serializer.serialize(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T deserialize(byte[] data, Class<T> clazz, String serializeType) {

        SerializerType serialize = SerializerType.queryByType(serializeType);
        if (serialize == null) {
            throw new RuntimeException("serialize is null");
        }
        ISerializer serializer = serializerMap.get(serialize);
        if (serializer == null) {
            throw new RuntimeException("serialize error");
        }

        try {
            return serializer.deserialize(data, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
