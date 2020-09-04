package com.yize.qqmusictest;

import com.yize.qqmusic.model.comment.CommentBean;
import com.yize.qqmusic.music.module.comment.QqMusicComment;
import com.yize.qqmusic.util.GsonConverter;
import org.junit.Test;

public class QqMusicCommentTest {
    @Test
    public void testComment(){
        QqMusicComment musicComment=new QqMusicComment();
        CommentBean commentBean=musicComment.getCommentBySongMid("97773",20,0);
        GsonConverter.printToJson(commentBean);
    }
}
