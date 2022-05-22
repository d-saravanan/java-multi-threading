package com.ds.mt.threading.techniques;

public class FourthTechnique {

    public static void main(String[] args) {
        new Thread(new FourthTask()).start();
        new Thread(() -> {
            System.out.println("Another thread");
        }).start();
    }
}

class FourthTask implements Runnable {
    private int id;
    private static int count = 0;

    public FourthTask() {
        id = ++count;

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