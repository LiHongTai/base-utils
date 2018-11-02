package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestGZipUtil extends TestCase {

    @Test
    public void testGzip() throws Exception{
        //读取文件
        String inputpath = System.getProperty("user.dir") + File.separatorChar + "sources"+ File.separatorChar + "006.jpg";
        FileInputStream in = new FileInputStream(inputpath);
        byte[] data = new byte[in.available()];
        in.read(data);
        in.close();

        System.out.println("压缩前,文件大小:"+data.length);
        byte[] afterGzip = GZipUtil.gzip(data);
        System.out.println("压缩后,文件大小:" + afterGzip.length);
        byte[] afterUnGzip = GZipUtil.ungzip(afterGzip);
        System.out.println("解压缩后,文件大小:"+afterUnGzip.length);

        String outputpath =  System.getProperty("user.dir") + File.separatorChar + "sources"+ File.separatorChar + "006-1.jpg";
        FileOutputStream out = new FileOutputStream(outputpath);
        out.write(afterUnGzip);
        out.close();
    }
}
