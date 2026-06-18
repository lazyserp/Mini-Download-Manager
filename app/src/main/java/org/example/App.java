package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {

        DownloadManager manager = new DownloadManager();

        System.out.println("Started Downloads !");
        System.out.println();

        // Create a pool with 10 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Submit 1000 download tasks
        for (int i = 0; i < 1000; i++) {
            executor.submit(new DownloadTask("file" + i, manager));
        }

        // No more tasks will be submitted
        executor.shutdown();

        // Wait for all submitted tasks to complete
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Some tasks are still running...");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println("Completed Downloads : " + manager.getCompletedDownloads());
    }
}