package com.ds.mt.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<TaskResult<Integer>> {

    static int counter = 0;
    private int id;
    private final int x;
    private final int y;
    private long milliss;

    public CallableTask(int x, int y, long milliss) {
        this.x = x;
        this.y = y;
        this.milliss = milliss;
        id = ++counter;
    }

    @Override
    public TaskResult<Integer> call() throws Exception {
        System.out.println(">>>> STARTING [" + Thread.currentThread().getName() + "] with id: [" + id + "]");
        TimeUnit.MILLISECONDS.sleep(milliss);
        System.out.println("***** ENDING [" + Thread.currentThread().getName() + "] with id: [" + id + "]");
        return new TaskResult<>(x + y, this);
    }

    public int getId() {
        return id;
    }
}

