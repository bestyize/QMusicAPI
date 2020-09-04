package com.yize.qqmusic.local.download;

import com.yize.qqmusic.music.module.searchdown.QqMusic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.*;

public class Downloader {
    private static final Logger logger= LogManager.getLogger(Downloader.class);
    private final ExecutorService executorService;

    public Downloader() {
        executorService=new ThreadPoolExecutor(
                5,
                32,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(32),
                new ExceedHandler());
    }

    private class ExceedHandler implements RejectedExecutionHandler {

        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("超过最大线程数");
        }
    }

    private DownloadListener downloadListener=new DownloadListener() {
        @Override
        public void onSuccess(DownloadItem item) {
            logger.info("successful:"+item.saveName);
        }

        @Override
        public void onFailed(DownloadItem item) {
            logger.info("failed:"+item.saveName);
        }

        @Override
        public void onCanceled(DownloadItem item) {
            logger.info("canceled:"+item.saveName);
        }

        @Override
        public void onProgress(DownloadItem item) {
            logger.info("progress:"+item.saveName+item.downloadedLen+"/"+item.fileSize);
        }
    };

    public void startDownload(DownloadItem item){
        File file=new File(item.saveFolder+File.separator+item.saveName);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
            RandomAccessFile raf=new RandomAccessFile(file,"rwd");
            raf.setLength(item.fileSize);
            raf.close();
            item.file=file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        executorService.submit(new DownloadWorker(item,downloadListener));
    }

    public void startDownload(List<DownloadItem> downloadItemList){
        for (DownloadItem item:downloadItemList){
            startDownload(item);
        }
    }

    private class DownloadWorker implements Runnable{
        DownloadItem item;
        DownloadListener listener;

        public DownloadWorker(DownloadItem item, DownloadListener listener) {
            this.item = item;
            this.listener = listener;
        }

        @Override
        public void run() {
            try {
                URL url=new URL(item.downloadLink);
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Range","bytes="+item.downloadedLen+"-"+item.fileSize);
                conn.setConnectTimeout(10000);
                RandomAccessFile raf=new RandomAccessFile(item.file,"rwd");
                raf.seek(item.downloadedLen);
                BufferedInputStream reader=new BufferedInputStream(conn.getInputStream());
                byte[] b=new byte[4096];
                int len;
                while ((len=reader.read(b))!=-1){
                    raf.write(b,0,len);
                    item.downloadedLen+=len;
                    listener.onProgress(item);
                }
                raf.close();
                reader.close();
                conn.disconnect();
                listener.onSuccess(item);

            } catch (Exception e) {
                e.printStackTrace();
                listener.onFailed(item);
            }
        }
    }


}
