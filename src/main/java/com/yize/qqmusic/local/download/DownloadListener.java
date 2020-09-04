package com.yize.qqmusic.local.download;

public interface DownloadListener {
    void onSuccess(DownloadItem item);
    void onFailed(DownloadItem item);
    void onCanceled(DownloadItem item);
    void onProgress(DownloadItem item);
}
