package com.yize.qqmusic.servlet;

import com.yize.qqmusic.model.mv.MvBean;
import com.yize.qqmusic.model.mv.MvInfo;
import com.yize.qqmusic.model.rank.DetailRankBean;
import com.yize.qqmusic.music.impl.mv.QqMusicMv;
import com.yize.qqmusic.music.impl.rank.QqMusicDetailRank;
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
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/api/mvsearch")
public class MvSearch extends HttpServlet {
    private static QqMusicMv musicMv;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        String batch=request.getParameter("batch");
        String mvVid=request.getParameter("vid");
        if(musicMv==null){
            musicMv=new QqMusicMv();
        }
        PrintWriter writer=response.getWriter();
        if(batch==null){
            MvInfo mvInfo=musicMv.getMvInfoByVid(mvVid);
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
            mvBeanList=musicMv.getMvInfoListByVid(Arrays.asList(vids));
        }

        writer.flush();
        writer.close();
    }
}
