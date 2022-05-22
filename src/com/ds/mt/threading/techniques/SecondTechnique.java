package com.ds.mt.threading.techniques;

public class SecondTechnique {

    public static void main(String[] args) {
        SecondTask st = new SecondTask();
        st.start();
        new SecondTask().start();
        System.out.println("Main Thread complete");
    }
}


class SecondTask extends Thread {
    private int id;
    private static int count = 0;

    public SecondTask() {
        id = ++count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Instance: " + id + " ; value: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}