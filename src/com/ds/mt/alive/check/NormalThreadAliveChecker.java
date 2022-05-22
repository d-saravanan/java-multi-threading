package com.ds.mt.alive.check;

import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class NormalThreadAliveChecker {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Done waiting for a second");
        });

        t1.start();

        while (t1.isAlive()) {
            System.out.println("Thread is still alive as on " + currentTimeMillis());
        }

        System.out.println("<<<<<<< Main completing. Thread state is : "+t1.isAlive());

    }


}
