package com.ds.mt.termination;

import java.util.concurrent.TimeUnit;

public class ManualTermination1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>> Starting Main");
        TaskForTermination task = new TaskForTermination(),
                task1 = new TaskForTermination(),
                task2 = new TaskForTermination();

        new Thread(task, "T1").start();
        new Thread(task1, "T2").start();
        new Thread(task2, "T3").start();

        TimeUnit.MILLISECONDS.sleep(3000);

        task2.cancelTask();
        task1.cancelTask();
        task.cancelTask();

        System.out.println("<<< Ending Main");

    }


}
