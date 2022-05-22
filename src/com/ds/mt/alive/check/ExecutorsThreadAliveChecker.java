package com.ds.mt.alive.check;

import com.ds.mt.callables.CallableTask;
import com.ds.mt.callables.TaskResult;
import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.concurrent.*;

public class ExecutorsThreadAliveChecker {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService execSvc = Executors.newCachedThreadPool(new NamedThreadFactory());

        Future<TaskResult<Integer>> result = execSvc.submit(new CallableTask(10, 90, 1000));

        FutureTask<TaskResult<Integer>> ft = new FutureTask<>(new CallableTask(99, 999, 499));
        execSvc.submit(ft);

        while (true) {
            if (!result.isDone()) System.out.println("Job still is in progress");
            if (!ft.isDone()) System.out.println("Future task is not yet done");
            TimeUnit.MILLISECONDS.sleep(250);
            if (result.isDone() && ft.isDone()) break;
        }
        execSvc.shutdown();

        System.out.println("result from normal task is: " + result.get().getResult());
        System.out.println("Result from future task is: " + ft.get().getResult());
    }


}
