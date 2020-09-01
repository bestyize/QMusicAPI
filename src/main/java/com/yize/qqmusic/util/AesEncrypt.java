package com.yize.qqmusic.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;


public class AesEncrypt {

    /**
     * 加密
     * 模式:AES/CBC/PKCS7Padding
     * 
     * @param encKey 秘钥
     * @param content 加密串
     * @return
     */
    public static String AESEncode( String content,String encKey, String ivParameter) throws Exception {


        int base = 16;
        byte[] keybyte = encKey.getBytes("UTF-8");
        if (keybyte.length % base != 0) {
            int groups = keybyte.length / base + (keybyte.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keybyte, 0, temp, 0, keybyte.length);
            keybyte = temp;
        }
        // 初始化  
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式  
        Key key = new SecretKeySpec(keybyte, "AES");
        try {
            // 初始化cipher  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivParameter.getBytes()));
            byte[] encryptedText = cipher.doFinal(content.getBytes());
            return new String(new Base64().encode(encryptedText)).replaceAll("\r\n", "");
        } catch (Exception e) {

        }
        return null;
    }
    /**
     * 解密
     * 
     * @param encodeRules 秘钥
     * @param content 解密串
     * @return
     */
    public static String AESDecode(String encodeRules, String content, String ivParameter) throws Exception {
        try {
            // 判断Key是否正确  
            if (encodeRules == null) {

                return null;
            }
            // 判断Key是否为16位  
            if (encodeRules.length() != 16) {
                return null;
            }
            byte[] raw = encodeRules.getBytes("UTF-8");
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            try {
                byte[] encrypted1 = new Base64().decode(content);//先用base64解密  
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {

                return null;
            }
        } catch (Exception ex) {

            return null;
        }
    }
}

