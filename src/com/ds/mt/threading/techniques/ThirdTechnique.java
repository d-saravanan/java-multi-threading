package com.ds.mt.threading.techniques;

public class ThirdTechnique {

    public static void main(String[] args) {
        new Task();
        new Task();
        new Task();
    }
}

class ThirdTask implements Runnable {
    private int id;
    private static int count = 0;

    public ThirdTask() {
        id = ++count;
        new Thread(this).start();

        new Thread(() -> {
            System.out.println("Another thread");
        }).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Instance: " + id + " ;value: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}