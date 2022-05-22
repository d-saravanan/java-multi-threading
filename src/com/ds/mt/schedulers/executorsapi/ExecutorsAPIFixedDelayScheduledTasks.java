package com.ds.mt.schedulers.executorsapi;

import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsAPIFixedDelayScheduledTasks {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(">>> Starting Main");
        //The below executor service uses a single thread for executing the scheduled tasks
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
        //The below one uses the scheduler thread pool for executing scheduled jobs
        service = Executors.newScheduledThreadPool(3, new NamedThreadFactory());

        System.out.println("Starting to schedule @ " + new Date());
        service.scheduleWithFixedDelay(new ScheduledTaskForExecutors(150), 200, 2000, TimeUnit.MILLISECONDS);
        service.scheduleWithFixedDelay(new ScheduledTaskForExecutors(150), 200, 2000, TimeUnit.MILLISECONDS);
        //The next run happens after 2000 ms from the end of the previous run in this mode of execution

//        service.scheduleAtFixedRate(new ScheduledTaskForExecutors(100), 200, 2000, TimeUnit.MILLISECONDS);
//        service.schedule(new ScheduledTaskForExecutors(100), 300, TimeUnit.MILLISECONDS);

        TimeUnit.MILLISECONDS.sleep(16000);
        service.shutdown();
        System.out.println("<<< Exiting Main");
    }

}

