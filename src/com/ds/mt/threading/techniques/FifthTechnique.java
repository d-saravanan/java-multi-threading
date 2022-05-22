package com.ds.mt.threading.techniques;

public class FifthTechnique {

    public static void main(String[] args) {
        //mainly used for UI Events
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Instance: " + Thread.currentThread().getId() + " ;value: " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

