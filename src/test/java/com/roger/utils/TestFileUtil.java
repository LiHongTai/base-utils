package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFileUtil extends TestCase {

    private String rootDir = System.getProperty("user.dir") + File.separatorChar + "sources"+ File.separatorChar;

    @Test
    public void testCopyFile(){
        String sourceFile = rootDir + "a.doc";
        String destFile = rootDir + "b.doc";
        File dest = new File(destFile);
        assertFalse(dest.exists());

        try {
            FileUtil.copyFile( sourceFile, destFile);
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        dest = new File(destFile);
        assertTrue(dest.exists());
        dest.delete();
    }

    @Test
    public void testGetFileList(){
        List<File> fileList = new ArrayList<>();
        FileUtil.getFileList(rootDir,fileList);
        assertTrue(fileList.size() == 5);
    }

}
