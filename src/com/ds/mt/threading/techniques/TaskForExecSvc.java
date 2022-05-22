package com.ds.mt.threading.techniques;

import java.util.concurrent.TimeUnit;

public class TaskForExecSvc implements Runnable {
    private static int id = 0;
    private int counter;

    public TaskForExecSvc() {
        counter = ++id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("#### Starting <TASK: " + counter + " > #########");

        for (int i = 0; i < 7; i++) {
            try {
                System.out.println("task: " + counter + " and name: [" + name + "] ; value: " + i);
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("\n");
        System.out.println("***** Completed <TASK: " + counter + " > **********");
    }
}
