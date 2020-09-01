package com.yize.qqmusic.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class RankBean {
    List<RankGroup> groupList;

    public List<RankGroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<RankGroup> groupList) {
        this.groupList = groupList;
    }

    class RankGroup{
        int groupId;
        String groupName;
        @SerializedName("toplist")
        List<TopRank> topRankList;

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public List<TopRank> getTopRankList() {
            return topRankList;
        }

        public void setTopRankList(List<TopRank> topRankList) {
            this.topRankList = topRankList;
        }

    }
}
