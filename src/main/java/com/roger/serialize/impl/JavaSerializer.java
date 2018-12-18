package com.roger.serialize.impl;

import com.roger.serialize.ISerializer;

import java.io.*;

public class JavaSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        if(obj == null){
            throw new NullPointerException();
        }

        ByteArrayOutputStream bos = null;
        ObjectOutputStream out = null;

        try {
            bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("序列化异常-" + e.getMessage());
        }finally {
            try {
                if(out != null){
                    out.close();
                }
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("流关闭异常-" + e.getMessage());
            }
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        if(data == null){
            throw new NullPointerException();
        }

        ByteArrayInputStream bis = null;
        ObjectInputStream in = null;

        try {
            bis = new ByteArrayInputStream(data);
            in = new ObjectInputStream(bis);
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("反序列化异常-" + e.getMessage());
        }finally {
            try {
                if(bis != null){
                    bis.close();
                }
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("流关闭异常-" + e.getMessage());
            }
        }

    }
}
