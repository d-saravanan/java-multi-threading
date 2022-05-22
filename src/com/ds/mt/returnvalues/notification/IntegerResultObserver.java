package com.ds.mt.returnvalues.notification;

public class IntegerResultObserver implements IResultNotifier<Integer> {

    private final String threadId;

    public IntegerResultObserver(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void Notify(Integer result) {
        System.out.println("The result is : " + result);
    }
}
