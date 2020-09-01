package com.yize.qqmusic.music;

import com.yize.qqmusic.model.SongBean;

import java.util.LinkedList;
import java.util.List;


public interface MusicHelper {
    /**
     * 搜索歌曲列表
     *
     * @param keyword 关键词
     * @param num     数量
     * @return 搜到的歌曲列表
     */
    List<SongBean> searchMusic(String keyword, int num);

    /**
     * 至少应该有个songid信息，获取全部链接
     *
     * @param songBean 歌曲信息，必须包含songId
     * @return
     */
    SongBean searchDownloadLink(SongBean songBean,String quality);

    /**
     * 根据songid批量获取
     * @param downloadInfoList
     * @return
     */
    default List<SongBean> searchDownloadLink(List<SongBean> downloadInfoList){
        return new LinkedList<>();
    }

    default List<SongBean> searchWithDownload(String keyword, int num){
        return new LinkedList<>();
    }

}
