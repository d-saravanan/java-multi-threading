package com.ds.mt.returnvalues;

public class NormalThreads {

    public static void main(String[] args) {

        ValueReturningTask v1 = new ValueReturningTask(1, 2, 2500);
        new Thread(v1).start();
        ValueReturningTask v2 = new ValueReturningTask(3, 4, 1500);
        new Thread(v2).start();
        ValueReturningTask v3 = new ValueReturningTask(5, 6, 500);
        new Thread(v3).start();
        //retrieval of the values blocks the main thread, unless the v1.getSum() completes,
        //we cannot get the value of v2 & v3 and so on...
        System.out.println(v1.getSum());
        System.out.println(v2.getSum());
        System.out.println(v3.getSum());
    }


}
