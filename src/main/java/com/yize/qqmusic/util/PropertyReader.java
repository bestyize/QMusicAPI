package com.yize.qqmusic.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final Logger logger= LogManager.getLogger(PropertyReader.class);
    public static String loadConfig(String item){
        Properties properties=new Properties();
        String property;
        try {
            InputStream is= PropertyReader.class.getClassLoader().getResourceAsStream("nameless.properties");
            properties.load(is);
            property=properties.getProperty(item);
        }catch (Exception e){
            logger.error("read "+item+" failed,reason :"+e.toString());
            property="";
        }
        return property;
    }
}
