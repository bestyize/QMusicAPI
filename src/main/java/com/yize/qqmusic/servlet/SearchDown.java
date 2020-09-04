package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.SongBean;
import com.yize.qqmusic.music.MusicHelper;
import com.yize.qqmusic.music.module.searchdown.QqMusic;
import com.yize.qqmusic.util.GsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/searchdown")
public class SearchDown extends HttpServlet {
    private static MusicHelper helper;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        String keyword=request.getParameter("keyword");
        String numStr=request.getParameter("num");
        int num;
        try {
            num=Integer.parseInt(numStr);
        }catch (Exception e){
            num=20;
        }
        if(helper==null){
            helper=new QqMusic();
        }
        List<SongBean> songBeanList=helper.searchWithDownload(keyword,num);
        PrintWriter writer=response.getWriter();
        String json= GsonConverter.toJson(songBeanList);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
