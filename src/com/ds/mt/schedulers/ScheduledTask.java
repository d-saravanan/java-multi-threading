package com.ds.mt.schedulers;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class ScheduledTask extends TimerTask {
    private static int counter = 0;
    private int instanceId;
    private final int millis;

    public ScheduledTask(int millis) {
        this.millis = millis;
        instanceId = ++counter;
    }

    @Override
    public void run() {
        System.out.println("Scheduled  at: " + this.scheduledExecutionTime()); //actual scheduled time
        System.out.println("Actual Run at: " + currentTimeMillis()); //actual running time of the job

        int result = 0;
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result += i;
            System.out.println("Calculated value: " + result + " in " + Thread.currentThread().getName() + " and instance: " + instanceId);
        }
        System.out.println("Task completed successfully in " + Thread.currentThread().getName() + " ; instance " + instanceId + " @ " + currentTimeMillis());
    }
}
