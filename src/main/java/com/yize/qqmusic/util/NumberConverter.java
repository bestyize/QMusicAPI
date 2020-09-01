package com.yize.qqmusic.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberConverter {
    private static final Logger logger= LogManager.getLogger(NumberConverter.class);
    public static int convert(String numStr,int defaultNum){
        try {
            defaultNum=Integer.valueOf(numStr);
        }catch (Exception e){
            logger.error("转换失败，使用默认值");
        }return defaultNum;
    }
}
