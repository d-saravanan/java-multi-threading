package com.ds.mt.threading.techniques;

public class Main {

    public static void main(String[] args) {
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
        new Task();
    }
}

class Task extends Thread {
    private int id;
    private static int count = 0;

    public Task() {
        id = ++count;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(id + " ; " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}