package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.mv.MvBean;
import com.yize.qqmusic.model.mv.MvInfo;
import com.yize.qqmusic.music.module.mv.QqMusicMvDownload;
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

@WebServlet("/api/mvdownload")
public class MvDownload extends HttpServlet {
    private static QqMusicMvDownload musicMv;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        String mvVid=request.getParameter("vid");
        String batch=request.getParameter("batch");
        if(musicMv==null){
            musicMv=new QqMusicMvDownload();
        }
        PrintWriter writer=response.getWriter();
        if(batch==null){
            MvBean bean=new MvBean();
            bean.setMvVid(mvVid);
            MvInfo mvInfo=musicMv.getMvDownloadLink(bean);
            String json= GsonConverter.toJson(mvInfo);
            writer.write(json);
        }else {
            String vids[]=mvVid.split(",");
            List<MvBean> mvBeanList=new LinkedList<>();
            for (String vid:vids){
                MvBean bean=new MvBean();
                bean.setMvVid(vid);
                mvBeanList.add(bean);
            }
            mvBeanList=musicMv.getMvDownloadLink(mvBeanList);
            writer.write(GsonConverter.toJson(mvBeanList));
        }

        writer.flush();
        writer.close();
    }
}
