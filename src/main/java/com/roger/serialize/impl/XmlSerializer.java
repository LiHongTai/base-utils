package com.roger.serialize.impl;

import com.roger.serialize.ISerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class XmlSerializer implements ISerializer {

    private static final XStream xStream = new XStream(new DomDriver());


    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }


    public <T> T deserialize(byte[] data, Class<T> clazz) {
        String xml = new String(data);
        return (T) xStream.fromXML(xml);
    }
}
