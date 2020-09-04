package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.base.Lyric;
import com.yize.qqmusic.music.module.lyric.QqMusicLyric;
import com.yize.qqmusic.util.GsonConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LyricSearch extends HttpServlet {
    private static QqMusicLyric musicLyric;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String songMid=request.getParameter("mid");
        if(musicLyric==null){
            musicLyric=new QqMusicLyric();
        }
        Lyric lyric=musicLyric.getLyricByMid(songMid);
        PrintWriter writer=response.getWriter();
        String json= GsonConverter.toJson(lyric);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
