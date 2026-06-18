package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) {

        DownloadManager manager = new DownloadManager();

        // Create a pool with 10 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(10);

        ArrayList<Future<DownloadResult>> futureList = new ArrayList<>();

        System.out.println("Started Downloads ! \n");

        // Submit 1000 download tasks
        for (int i = 0; i < 1000; i++) {
            Future<DownloadResult> future = executor.submit(new DownloadTask("file" + i, manager));
            futureList.add(future);
        }

        // No more tasks will be submitted
        executor.shutdown();

        for (var future : futureList) {
            try {
                DownloadResult result = future.get();
                System.out.println(result);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("Completed Downloads : " + manager.getCompletedDownloads());
    }
}