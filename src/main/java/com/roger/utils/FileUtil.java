package com.roger.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class FileUtil {

    /**
     * 这里传入的path为绝对路径，或者为省略 System.getProperty("user.dir") 的path
     * @param source
     * @param destination
     * @throws IOException
     */
    public static void copyFile(String source, String destination) throws IOException {
        //文件输入流
        FileInputStream fin = new FileInputStream(source);
        //文件输出流
        FileOutputStream fout = new FileOutputStream(destination);
        //获取读文件通道
        FileChannel readChannel = fin.getChannel();
        //获取写文件通道
        FileChannel writeChannel = fout.getChannel();
        //读入数据缓存
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int len = -1;
        System.out.println(" 初始化: position = " + byteBuffer.position() + ";Capacity = " + byteBuffer.capacity() + "; limit = " + byteBuffer.limit());
        System.out.println("进入循环读取数据");
        while ((len = readChannel.read(byteBuffer)) != -1) {
            System.out.println("一次读取完成  position = " + byteBuffer.position() + ";Capacity = " + byteBuffer.capacity() + "; limit = " + byteBuffer.limit());
            byteBuffer.flip();
            System.out.println("执行flip方法后 : position = " + byteBuffer.position() + ";Capacity = " + byteBuffer.capacity() + "; limit = " + byteBuffer.limit());
            writeChannel.write(byteBuffer);
            System.out.println("写入目标文件后: position = " + byteBuffer.position() + ";Capacity = " + byteBuffer.capacity() + "; limit = " + byteBuffer.limit());
            byteBuffer.clear();
            System.out.println("执行clear方法后: position = " + byteBuffer.position() + ";Capacity = " + byteBuffer.capacity() + "; limit = " + byteBuffer.limit());
            System.out.println("准备进入下次循环");
        }

        readChannel.close();
        writeChannel.close();
    }

    /**
     * 根据指定的目录，获取目录及其子目录下的所有文件
     * 并存储到一个容器中去
     * @param dir
     * @param fileList
     */
    public static void getFileList(String dir, List<File> fileList){
        File root = new File(dir);
        if(!root.exists()){
            return;
        }
        if(root.isFile()){
            fileList.add(root);
            return;
        }
        File[] files = root.listFiles();
        for(File file : files){
            if(file.isFile()){
                fileList.add(file);
                continue;
            }
            getFileList(file.getAbsolutePath(),fileList);
        }
    }
}
