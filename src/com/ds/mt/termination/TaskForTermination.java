package com.ds.mt.termination;

import com.ds.mt.common.ForEverRunnable;

import java.util.concurrent.TimeUnit;

public class TaskForTermination extends ForEverRunnable {

    public void cancelTask() {
        shutdown = true;
    }

    @Override
    public void doRun(int iteration) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000));
        System.out.println("Processing " + iteration + " from " + Thread.currentThread().getName() + " in instance: " + instanceId);
    }
}
