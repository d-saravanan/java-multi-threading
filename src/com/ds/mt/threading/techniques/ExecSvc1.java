package com.ds.mt.threading.techniques;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecSvc1 {

    public static void main(String[] args) {
        System.out.println("....Main starts here");

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool(); //There is no limit on the # of threads
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //for synchronized access to a shared resource
        for (int i = 0; i < 13; i++) {
            executorService.submit(new TaskForExecSvc());
        }
        executorService.shutdown(); //without this, the program will NEVER TERMINATE
        System.out.println("Main ends here....");
    }

}
