package com.roger.serialize.enumeration;

import org.apache.commons.lang3.StringUtils;

public enum SerializerType {

    JavaSerializer("JavaSerializer"),
    HessianSerializer("HessianSerializer"),
    JSONSerializer("JSONSerializer"),
    ProtoStuffSerializer("ProtoStuffSerializer"),
    XmlSerializer("XmlSerializer"),
    MarshallingSerializer("MarshallingSerializer");

    private String serializerType;

    private SerializerType(String serializerType) {
        this.serializerType = serializerType;
    }

    public static SerializerType queryByType(String serializerType) {
        if (StringUtils.isBlank(serializerType)) {
            return null;
        }

        for (SerializerType serialize : SerializerType.values()) {
            if (StringUtils.equals(serializerType, serialize.getSerializerType())) {
                return serialize;
            }
        }
        return null;
    }

    public String getSerializerType() {
        return serializerType;
    }
}
