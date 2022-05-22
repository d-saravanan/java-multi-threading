package com.ds.mt.daemons;

import com.ds.mt.callables.TaskResult;

import java.util.concurrent.TimeUnit;

public class DaemonTask implements Runnable {
    static int counter = 0;
    private int id, sum;
    private final int x;
    private final int y;
    private long milliss;

    public DaemonTask(int x, int y, long milliss) {
        this.x = x;
        this.y = y;
        this.milliss = milliss;
        id = ++counter;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName() + " [" + (Thread.currentThread().isDaemon() ? "DAEMON" : "USER") + "]";

        System.out.println(">>>> STARTING [" + threadName + "] with id: [" + id + "]");
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliss);
                System.out.println(threadName + " [ " + id + "] -" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("***** ENDING [" + threadName + "] with id: [" + id + "]");
        sum = x + y;
    }
}
