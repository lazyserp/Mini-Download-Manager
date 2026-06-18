package org.example;

public class DownloadManager 
{
        //Critical section :  it is shared by multiple threads"
        private volatile int completedDownloads = 0;

        //using synchronized keyword makes this funciton as a locked resrouce , only 1 thread at a time inside this
        public synchronized void incrementCompletedDownloads() {
            
            completedDownloads++;
        }

        public synchronized int getCompletedDownloads() {
            return completedDownloads;
        }
}
