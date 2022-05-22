package com.ds.mt.schedulers.executorsapi;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class ScheduledTaskForExecutors implements Runnable {
    private static int counter = 0;
    private int instanceId;
    private final int millis;

    public ScheduledTaskForExecutors(int millis) {
        this.millis = millis;
        instanceId = ++counter;
    }

    @Override
    public void run() {
        System.out.println("Actual Run at: " + new Date()); //actual running time of the job

        int result = 0;
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result += i;
//            System.out.print("Calculated value: " + result + " in " + Thread.currentThread().getName() + " and instance: " + instanceId);
        }
        System.out.println("\nTask completed successfully in " + Thread.currentThread().getName() + " ; instance " + instanceId + " @ " + new Date());
    }
}
