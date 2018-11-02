package com.roger.utils;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;
import java.util.ResourceBundle;

public class TestPropertiesUtil extends TestCase {

    private static final String FILE_PATH_4_CLASS_PATH = "/conf/jdbc.properties";
    private static final String FILE_PATH_4_CLASS_LOADER = "conf/jdbc.properties";

    private static final String FILE_PATH_4_RESOURCE_BUNDLE = "conf/jdbc";

    @Test
    public void testReadPropertiesByClassPath() {
        Properties prop = PropertiesUtil.readPropertiesByClassPath(FILE_PATH_4_CLASS_PATH);
        Assert.assertTrue("root".equals(prop.get("db.user")));
        Assert.assertTrue("root".equals(prop.get("db.password")));
    }

    @Test
    public void testReadPropertiesByClassLoader() {
        Properties prop = PropertiesUtil.readPropertiesByClassLoader(FILE_PATH_4_CLASS_LOADER);
        Assert.assertTrue("root".equals(prop.get("db.user")));
        Assert.assertTrue("root".equals(prop.get("db.password")));
    }

    @Test
    public void testReadPropertiesByClassLoader2() {
        Properties prop = PropertiesUtil.readPropertiesByClassLoader2(FILE_PATH_4_CLASS_LOADER);
        Assert.assertTrue("root".equals(prop.get("db.user")));
        Assert.assertTrue("root".equals(prop.get("db.password")));
    }

    @Test
    public void testReadPropertiesByResourceBoundle() {
        ResourceBundle resourceBundle = PropertiesUtil.readPropertiesByResourceBundle(FILE_PATH_4_RESOURCE_BUNDLE);
        Assert.assertTrue("root".equals(resourceBundle.getString("db.user")));
        Assert.assertTrue("root".equals(resourceBundle.getString("db.password")));

    }
}
