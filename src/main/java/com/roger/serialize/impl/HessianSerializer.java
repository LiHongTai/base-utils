package com.roger.serialize.impl;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.roger.serialize.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        if(obj == null){
            throw new NullPointerException();
        }

        ByteArrayOutputStream bos = null;
        HessianOutput hessianOutput = null;

        try {
            bos = new ByteArrayOutputStream();
            hessianOutput = new HessianOutput(bos);
            hessianOutput.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("序列化异常-" + e.getMessage());
        }finally {
            try {
                if(hessianOutput != null){
                    hessianOutput.close();
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
        HessianInput hessianInput = null;

        try {
            bis = new ByteArrayInputStream(data);
            hessianInput = new HessianInput(bis);
            return (T) hessianInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException("反序列化异常-" + e.getMessage());
        }finally {
            try {
                if(bis != null){
                    bis.close();
                }
                if(hessianInput != null){
                    hessianInput.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("流关闭异常-" + e.getMessage());
            }
        }

    }
}
