package com.ds.mt.threading.techniques;

public class NamedThreads1 {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Inside " + Thread.currentThread().getName());
        }, "One").start();

        Thread t2 = new Thread(new TaskForExecSvc());
        t2.setName("Worker-2");
        t2.start();
    }

}
