package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.base.Singer;
import com.yize.qqmusic.music.module.singer.QqMusicSingerRank;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.NumberConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/api/singerrank")
public class SingerRank extends HttpServlet {
    private static QqMusicSingerRank helper;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        if(helper==null){
            helper=new QqMusicSingerRank();
        }
        String ranks=request.getParameter("ranks");
        String pageStr=request.getParameter("page");
        List<Singer> singerList=new LinkedList<>();
        if(ranks!=null&&ranks.equals("top")){
            int page=NumberConverter.convert(pageStr,1);
            singerList=helper.getTopRank(page);
        }else {
            int area=NumberConverter.convert(request.getParameter("area"),-100);
            int sex=NumberConverter.convert(request.getParameter("sex"),-100);
            int genre=NumberConverter.convert(request.getParameter("genre"),-100);
            int index=NumberConverter.convert(request.getParameter("index"),-100);
            int sin=NumberConverter.convert(request.getParameter("sin"),-100);
            int curPage=NumberConverter.convert(request.getParameter("curPage"),-100);
            singerList=helper.getTopRank(area,sex,genre,index,sin,curPage);
        }
        PrintWriter writer=response.getWriter();
        writer.write(GsonConverter.toJson(singerList));
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
