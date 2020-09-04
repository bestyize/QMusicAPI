package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.music.module.rank.QqMusicDetailRank;
import com.yize.qqmusic.util.GsonConverter;
import com.yize.qqmusic.util.NumberConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/api/detailrank")
public class DetailRank extends HttpServlet {
    private static QqMusicDetailRank detailRank;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        int topId= NumberConverter.convert(request.getParameter("topid"),62);//topid和num是对应的
        int num= NumberConverter.convert(request.getParameter("num"),300);
        String period=request.getParameter("period");
        if(detailRank==null){
            detailRank=new QqMusicDetailRank();
        }
        if(period==null){
            SimpleDateFormat dateFormater=new SimpleDateFormat("YYYY-MM-dd");
            period=dateFormater.format(new Date());
        }
        DetailRankBean detailRankBean=detailRank.getRankDetail(topId,num,period);
        PrintWriter writer=response.getWriter();
        String json= GsonConverter.toJson(detailRankBean);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
