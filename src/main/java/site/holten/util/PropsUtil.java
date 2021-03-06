package site.holten.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by AllenKO on 2015/10/4.
 * 加载属性文件工具类
 */
public class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     *
     * @param filename 属性文件名
     * @return 属性对象
     */
    public static Properties loadProps(String filename) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (inputStream == null) {
                throw new FileNotFoundException(filename + " is not found!");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Load Properties file failure", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("Close Input Stream failure!", e);
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符串属性（默认为空）
     *
     * @param props 属性对象
     * @param key   属性键名
     * @return 属性值
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    /**
     * 获取字符串属性（可指定默认值）
     *
     * @param props        属性对象
     * @param key          属性键名
     * @param defaultvalue 默认值
     * @return 属性值
     */
    public static String getString(Properties props, String key, String defaultvalue) {
        String value = defaultvalue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取整型数属性（可指定默认值）
     *
     * @param props        属性对象
     * @param key          属性键名
     * @param defaultvalue 默认值
     * @return 属性值
     */
    public static int getInt(Properties props, String key, int defaultvalue) {
        int value = defaultvalue;
        if (props.containsKey(key)) {
            value =Integer.parseInt(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取字符串属性（默认为空）
     *
     * @param props 属性对象
     * @param key   属性键名
     * @return 属性值
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }

}
