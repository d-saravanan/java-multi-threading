package com.ds.mt.returnvalues.notification;

public class NonBlockingRetrieval {

    public static void main(String[] args) {

        ValueNotifyingTask v1 = new ValueNotifyingTask(1, 2, 1500, new IntegerResultObserver("Thread-1"));
        new Thread(v1).start();
        ValueNotifyingTask v2 = new ValueNotifyingTask(3, 4, 2500, new IntegerResultObserver("Thread-2"));
        new Thread(v2).start();
        ValueNotifyingTask v3 = new ValueNotifyingTask(5, 6, 500, new IntegerResultObserver("Thread-3"));
        new Thread(v3).start();

    }

}
