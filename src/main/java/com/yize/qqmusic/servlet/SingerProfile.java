package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.impl.QqMusic;
import com.yize.qqmusic.music.impl.QqMusicSingerProfile;
import com.yize.qqmusic.util.GsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/api/singerprofile")
public class SingerProfile extends HttpServlet {
    private static QqMusicSingerProfile helper;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        String singerMid=request.getParameter("singermid");
        String numStartStr=request.getParameter("start");
        String countStr=request.getParameter("count");
        String all=request.getParameter("all");
        int numStart;
        int count;
        try {
            numStart=Integer.parseInt(numStartStr);
            count=Integer.parseInt(countStr);
        }catch (Exception e){
            numStart=0;
            count=0;
        }
        if(helper==null){
            helper=new QqMusicSingerProfile();
        }
        List<SongBean> songBeanList=new LinkedList<>();
        if(all!=null){
            songBeanList=helper.getAllSongBySingerMid(singerMid);
        }else {
            songBeanList=helper.getSongBySingerMid(singerMid,numStart,count);
        }
        PrintWriter writer=response.getWriter();
        writer.write(GsonConverter.toJson(songBeanList));
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}