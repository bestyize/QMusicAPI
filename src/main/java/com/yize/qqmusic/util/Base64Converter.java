package com.yize.qqmusic.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Converter {
    private static final Logger logger= LogManager.getLogger(Base64Converter.class);
    final static Base64.Encoder encoder = Base64.getEncoder();
    final static Base64.Decoder decoder = Base64.getDecoder();

    public static String encode(String clearText) {
        byte[] b = new byte[0];
        try {
            b = clearText.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("base64 encode failed");
        }
        String encodedText = encoder.encodeToString(b);
        return encodedText;
    }

    public static String decode(String encodedText) {
        String clearText=null;
        try {
            clearText = new String(decoder.decode(encodedText), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("base64 decode failed");
        }
        return clearText;
    }
}
