package org.example;

public class DownloadManager 
{
        private int completedDownloads = 0;

        public void incrementCompletedDownloads() {
            completedDownloads++;
        }

        public int getCompletedDownloads() {
            return completedDownloads;
        }
}
