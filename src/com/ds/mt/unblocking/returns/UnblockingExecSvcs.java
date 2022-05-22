package com.ds.mt.unblocking.returns;

import com.ds.mt.callables.CallableTask;
import com.ds.mt.callables.TaskResult;
import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.concurrent.*;

public class UnblockingExecSvcs {

    public static void main(String[] args) {

        ExecutorService svc = Executors.newCachedThreadPool(new NamedThreadFactory());

        CompletionService<TaskResult<Integer>> completionService = new ExecutorCompletionService<>(svc);

        completionService.submit(new CallableTask(1, 2, 2300));
        completionService.submit(new CallableTask(3, 4, 1300));
        completionService.submit(new CallableTask(5, 6, 900));

        svc.shutdown();

        for (int i = 0; i < 3; i++) {
            try {
                TaskResult<Integer> result = completionService.take().get();
                System.out.println("The result is : " + result.getResult() + " for the task id: " + result.getTask().getId());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}
