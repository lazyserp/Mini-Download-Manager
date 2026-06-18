public class DownloadTask implements Runnable{
    private String fileName;

    DownloadTask(String fileName)
    {
        this.fileName = fileName;
    }

    public void run()
    {
        System.out.println("FileName:  " + fileName);
        System.out.println("Thread Name: " + Thread.currentThread().getName());

        System.out.println("Download Progress :");

        for(int i=0 ; i <= 10 ;i++)
        {
            System.out.println("Downloading " + fileName + i*10 + "%");
            Thread.sleep(500);
        }
    }
}
