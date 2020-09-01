package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.MusicHelper;
import com.yize.qqmusic.music.impl.QqMusic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/searchdown")
public class SearchDown extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MusicHelper helper=new QqMusic();
//        List<SongBean> songBeanList=helper.searchWithDownload(keyword,num);
    }
}
