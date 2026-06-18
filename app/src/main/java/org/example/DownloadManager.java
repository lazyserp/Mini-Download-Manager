package org.example;

public class DownloadManager 
{
        //Critical section :  it is shared by multiple threads"
        private int completedDownloads = 0;

        //using synchronized keyword makes this funciton as a locked resrouce , only 1 thread at a time inside this
        public  void incrementCompletedDownloads() {
            
            completedDownloads++;
        }

        public int getCompletedDownloads() {
            return completedDownloads;
        }
}
