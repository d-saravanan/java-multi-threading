package com.ds.mt.schedulers.threadsapi;

import com.ds.mt.schedulers.ScheduledTask;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class SampleTaskScheduling {

    public static void main(String[] args) throws InterruptedException {
        //use short-lived tasks in same timer
        //for tasks that might take long, use a separate timer
        Timer timer = new Timer();
        System.out.println("Scheduling @ " + currentTimeMillis()); //time of setting-up the schedules
        //below line schedules a task to be executed at 100MS after app start
        TimerTask taskA = new ScheduledTask(100);
        timer.schedule(taskA, 100L);
        //below line schedules a task to be executed at 1 second after app start
        TimerTask taskB = new ScheduledTask(150);
        timer.schedule(taskB, 1000L);
        //below line schedules a task after 1 second from the time at which this line is executed
        //if the scheduled date is more than the time in which cancel is called, the task is never executed.
        // ex: set the amountToAdd as 5 and the task never runs because the cancel gets invoked before that
        //This means that cancel allows all running tasks to complete and doesn't take up new tasks for scheduled run
        Date scheduledDate = Date.from(Instant.now().plus(2, ChronoUnit.SECONDS));
        timer.schedule(new ScheduledTask(100), scheduledDate);

        TimeUnit.MILLISECONDS.sleep(1500);
        taskB.cancel();

        System.out.println("************** waiting for 2.5 seconds and cancelling all future tasks in timer ************");
        TimeUnit.MILLISECONDS.sleep(2000);
        timer.cancel();
        //The below line will cause exception as the timer has been marked for cancellation
        // and will no longer accept new schedules
//      timer.schedule(new ScheduledTask(200), 100L);
        System.out.println("Main Thread Ending ....");
    }

}

