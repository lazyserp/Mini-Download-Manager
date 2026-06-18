package org.example;

import java.util.concurrent.Callable;

public class DownloadTask implements Callable<DownloadResult>{
    private String fileName;
    private DownloadManager downloadManager;

    DownloadTask(String fileName,DownloadManager downloadManager)
    {
        this.fileName = fileName;
        this.downloadManager = downloadManager;
    }

    @Override
    public DownloadResult call() throws Exception
    {

        long startTime = System.currentTimeMillis();
        Thread.sleep(100);
        long endTime = System.currentTimeMillis();

        DownloadResult downloadResult = new DownloadResult(fileName,endTime-startTime,true);
        downloadManager.incrementCompletedDownloads();

        return downloadResult;
    }
}
