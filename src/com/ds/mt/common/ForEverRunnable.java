package com.ds.mt.common;

public abstract class ForEverRunnable implements Runnable {
    protected static int counter = 0;
    protected volatile int instanceId;
    protected volatile boolean shutdown;

    protected void exceptionHandler(InterruptedException e) {
        System.out.println("Exception occurred while processing the instance [" + instanceId + "] in thread named [" + Thread.currentThread().getName() + "]");
        e.printStackTrace();
    }

    public ForEverRunnable() {
        instanceId = ++counter;
    }

    public abstract void doRun(int iteration) throws InterruptedException;

    @Override
    public void run() {
        System.out.println(">>> Starting " + Thread.currentThread().getName() + " on " + instanceId);
        for (int i = 0; ; i++) {
            synchronized (this) {
                if (shutdown) break;
            }
            try {
                doRun(i);
            } catch (InterruptedException e) {
                exceptionHandler(e);
            }
        }
        System.out.println("<<< completing " + Thread.currentThread().getName() + " on " + instanceId);
    }
}
