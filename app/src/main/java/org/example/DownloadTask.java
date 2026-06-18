package org.example;

public class DownloadTask implements Runnable{
    private String fileName;
    private DownloadManager downloadManager;

    DownloadTask(String fileName,DownloadManager downloadManager)
    {
        this.fileName = fileName;
        this.downloadManager = downloadManager;
    }

    public void run()
    {

        System.out.println("Thread " + Thread.currentThread().getName() + " started Download "  + fileName );


        try
            {
                Thread.sleep(1);
            }
            catch( InterruptedException e)
            {
                System.out.println( "Interrupted !");
            }

        System.out.println();
        System.out.println("Thread " + Thread.currentThread().getName() + " comepleted Download "  + fileName );

            

        //Simulating download Progress
        // for(int i=0 ; i <= 10 ;i++)
        // {
        //     System.out.println("Downloading " + fileName + " " + i*10 + "%");
        //     try
        //     {
        //         Thread.sleep(500);
        //     }
        //     catch( InterruptedException e)
        //     {
        //         System.out.println( "Interrupted !");
        //     }

        // }

        downloadManager.incrementCompletedDownloads();
    }
}
