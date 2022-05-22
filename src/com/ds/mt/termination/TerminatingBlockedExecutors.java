package com.ds.mt.termination;

import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.concurrent.*;

public class TerminatingBlockedExecutors {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(">>> starting main ....");

        ExecutorService svc = Executors.newCachedThreadPool(new NamedThreadFactory());

        Future<Integer> r1 = svc.submit(new CancellableTask()),
                r2 = svc.submit(new CancellableTask());

        TimeUnit.MILLISECONDS.sleep(2750);

        r1.cancel(true);
        r2.cancel(true);

        System.out.println(r1.get());
        System.out.println(r2.get());

        svc.shutdown();
        System.out.println("<<< completing main ....");
    }


}

class CancellableTask implements Callable<Integer> {
    protected static int counter = 0;
    protected volatile int instanceId;

    public CancellableTask() {
        instanceId = ++counter;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(">>> Starting " + Thread.currentThread().getName() + " on " + instanceId);
        int result = 5;
        for (int i = 1; i < 100; i++) {
            try {
                result *= (i * i);
                TimeUnit.MILLISECONDS.sleep(749);
                System.out.println("Now Processed value: " + result + " from " + Thread.currentThread().getName() + " & instance: " + instanceId);
            } catch (InterruptedException e) {
                System.out.printf("Task Cancellation done in " + Thread.currentThread().getName() + " for task: " + instanceId);
                result = -1;
                break;
            }
        }
        System.out.println("<<< completing " + Thread.currentThread().getName() + " on " + instanceId);
        return result;
    }
}