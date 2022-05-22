package com.ds.mt.schedulers.executorsapi;

import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class ExecutorsAPIScheduledTasks {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>> Starting Main");
        //The below executor service uses a single thread for executing the scheduled tasks
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
        //The below one uses the scheduler thread pool for executing scheduled jobs
        service = Executors.newScheduledThreadPool(3, new NamedThreadFactory());

        System.out.println("Starting to schedule @ " + currentTimeMillis());
        service.schedule(new ScheduledTaskForExecutors(100), 100, TimeUnit.MILLISECONDS);
        service.schedule(new ScheduledTaskForExecutors(100), 200, TimeUnit.MILLISECONDS);
        service.schedule(new ScheduledTaskForExecutors(100), 300, TimeUnit.MILLISECONDS);

        TimeUnit.MILLISECONDS.sleep(5000);
        service.shutdown();
        System.out.println("<<< Exiting Main");
    }

}

