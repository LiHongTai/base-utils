package com.roger.utils;

import java.util.Arrays;

public class ByteUtilTest {

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        String key = "name";

        int h = key.hashCode();
        int hR = (h >>> 16);
        int hKey = hash(key);
        System.out.println("byte32：" + Arrays.toString(ByteUtil.intToByte32(h)));
        System.out.println("无符号右移：" + Arrays.toString(ByteUtil.intToByte32(hR)));

        System.out.println("最终结果：" + Arrays.toString(ByteUtil.intToByte32(hKey)));
    }
}
