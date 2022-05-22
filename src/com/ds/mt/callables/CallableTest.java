package com.ds.mt.callables;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) {
        System.out.println("... Starting main");
        ExecutorService svc = Executors.newCachedThreadPool();

        Future<TaskResult<Integer>> result = svc.submit(new CallableTask(1, 2, 2000));
        Future<TaskResult<Integer>> result1 = svc.submit(new CallableTask(3, 4, 2000));
        Future<TaskResult<Integer>> result2 = svc.submit(new CallableTask(5, 6, 2000));

        svc.shutdown();

        try {
            System.out.println("The result is :" + result.get()); //blocks the call and gets the execution complete,
            // results are retrieved by the order in which these methods are called and not in the order they complete exec
            System.out.println("The result1 is :" + result1.get());
            System.out.println("The result2 is :" + result2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main Ending .....");
    }

}
