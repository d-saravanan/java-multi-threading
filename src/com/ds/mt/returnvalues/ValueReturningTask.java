package com.ds.mt.returnvalues;

public class ValueReturningTask implements Runnable {
    private static int counter = 0;
    private int id;
    private final int x;
    private final int y;
    private final long milliSeconds;
    private volatile boolean done = false;

    public synchronized int getSum() {
        while (!done) {
            // to make sure that the main thread that calls this method is blocked
            // until the spawn thread has completed the execution
            try {
                System.out.println("Waiting from " + Thread.currentThread().getName());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    private int sum;

    public ValueReturningTask(int x, int y, long milliSeconds) {
        id = ++counter;
        this.x = x;
        this.y = y;
        this.milliSeconds = milliSeconds;
    }

    @Override
    public void run() {
        System.out.println("<< STARTING  [ " + Thread.currentThread().getName() + "_" + id + "] ... >>>");
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = x + y;
        System.out.println("**** Done [ " + Thread.currentThread().getName() + "_" + id + "] ... ***");
        done = true; //to break the loop in the getter
        synchronized (this) {
            System.out.println("notifying from " + Thread.currentThread().getName());
            this.notify(); //to notify that the thread's job is done so that the calling threads that were on hold can resume (main thread can read value)
        }
    }
}
