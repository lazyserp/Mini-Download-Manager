package org.example;

public class DownloadResult {
    public String fileName;
    public long downloadTime;
    public boolean success;

    DownloadResult(String fileName,long downloadTime,boolean success)
    {
        this.fileName = fileName;
        this.downloadTime = downloadTime;
        this.success = success;
    }

    @Override
    public String toString() {
        return "DownloadResult{" +
                "fileName='" + fileName + '\'' +
                ", downloadTime=" + downloadTime +
                ", success=" + success +
                '}';
}
}
