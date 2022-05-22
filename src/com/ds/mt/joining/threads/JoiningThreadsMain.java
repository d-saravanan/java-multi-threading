package com.ds.mt.joining.threads;

import com.ds.mt.termination.TaskForTermination;

import java.util.concurrent.TimeUnit;

public class JoiningThreadsMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>>STARTING ....");

        Thread t1 = new Thread(new TaskForJoiningThreads(61, 99, 1000)),
                t2 = new Thread(new TaskForJoiningThreads(41, 99, 750)),
                t3 = new Thread(new TaskForJoiningThreads(51, 99, 500)),
                t4 = new Thread(new TaskForJoiningThreads(31, 99, 1000));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("<<<< Ending");
    }

}

class TaskForJoiningThreads implements Runnable {
    private static int counter;
    private final int s;
    private final int e;
    private final int millis;
    private volatile int instanceid;

    public TaskForJoiningThreads(int s, int e, int millis) {
        this.s = s;
        this.e = e;
        this.millis = millis;
        instanceid = ++counter;
    }

    @Override
    public void run() {
        int result = 0;
        for (int i = s; i < e; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(millis);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            result += i;
            System.out.println("Printing " + result + " from " + Thread.currentThread().getName() + " in instance id: " + instanceid);
        }
    }
}