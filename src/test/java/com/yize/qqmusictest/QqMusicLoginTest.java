package com.yize.qqmusictest;

import com.yize.qqmusic.music.module.login.Login;
import org.junit.Test;

public class QqMusicLoginTest {
    @Test
    public void testLogin(){
        Login login=new Login();
        login.getToken();
    }
}
