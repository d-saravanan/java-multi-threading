package com.ds.mt.returnvalues.notification;

public class ValueNotifyingTask implements Runnable {
    private static int counter = 0;
    private int id;
    private final int x;
    private final int y;
    private final long milliSeconds;
    private final IResultNotifier<Integer> notifier;

    public ValueNotifyingTask(int x, int y, long milliSeconds, IResultNotifier<Integer> notifier) {
        this.notifier = notifier;
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

        System.out.println("**** Done [ " + Thread.currentThread().getName() + "_" + id + "] ... ***");
        notifier.Notify(x + y);
    }


}
