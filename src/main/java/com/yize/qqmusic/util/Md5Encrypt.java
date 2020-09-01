package com.yize.qqmusic.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Encrypt {
    //必须要重视编码问题了！折腾了好多天才发现MD5要用UTF-8形式加密
    public static String convertToMd5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes("utf-8"));
        } catch (Exception e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
