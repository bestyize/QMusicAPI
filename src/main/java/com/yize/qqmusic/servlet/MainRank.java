package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.rank.MainRankBean;
import com.yize.qqmusic.music.impl.rank.QqMusicMainRank;
import com.yize.qqmusic.util.GsonConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/mainrank")
public class MainRank extends HttpServlet {
    private static QqMusicMainRank mainRank;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        if(mainRank==null){
            mainRank=new QqMusicMainRank();
        }
        MainRankBean mainRankBean=mainRank.getMainRank();
        PrintWriter writer=response.getWriter();
        String json= GsonConverter.toJson(mainRankBean);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
