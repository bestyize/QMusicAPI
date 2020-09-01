package com.yize.qqmusictest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Base64Test {
    @Test
    public void testDecode() throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("%7B%22detail%22%3A%7B%22module%22%3A%22musicToplist.ToplistInfoServer%22%2C%22method%22%3A%22GetDetail%22%2C%22param%22%3A%7B%22topId%22%3A4%2C%22offset%22%3A0%2C%22num%22%3A20%2C%22period%22%3A%222020-09-01%22%7D%7D%2C%22comm%22%3A%7B%22ct%22%3A24%2C%22cv%22%3A0%7D%7D#","utf-8"));
    }
}
