package com.yize.qqmusic.local.download;

import java.io.File;

public class DownloadItem {
    public String downloadLink;
    public String saveName;
    public long fileSize;
    public long downloadedLen;
    public String saveFolder;
    public File file;

    public DownloadItem(String downloadLink, String saveName, long fileSize, long downloadedLen) {
        this.downloadLink = downloadLink;
        this.saveName = saveName;
        this.fileSize = fileSize;
        this.downloadedLen = downloadedLen;
        this.saveFolder="/home/yize/Music";
    }
}
