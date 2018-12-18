package com.roger.serialize;

public interface ISerializer {

    <T> byte[] serialize(T clazz);

    <T> T deserialize(byte[] data, Class<T> clazz);
}
