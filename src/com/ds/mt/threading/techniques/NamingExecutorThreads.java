package com.ds.mt.threading.techniques;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingExecutorThreads {


    public static void main(String[] args) {
        System.out.println("<< Main Started Here >>");
        ExecutorService service = Executors.newFixedThreadPool(3, new NamedThreadFactory());
        service = Executors.newCachedThreadPool(new NamedThreadFactory());
        for (int i = 0; i < 3; i++) {
            service.submit(new TaskForExecSvc());
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            service.submit(new TaskForExecSvc());
        }


        service.shutdown();
        System.out.println("<< Main Ends Here >>");
    }


}
