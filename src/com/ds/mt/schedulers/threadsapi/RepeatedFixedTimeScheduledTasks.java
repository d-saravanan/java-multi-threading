package com.ds.mt.schedulers.threadsapi;

import com.ds.mt.schedulers.ScheduledTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class RepeatedFixedTimeScheduledTasks {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started Main .....");

        TimerTask task1 = new ScheduledTask(200),
                task2 = new ScheduledTask(150);
        System.out.println("Scheduling in main completed at: " + currentTimeMillis());

        Timer timer = new Timer("RecurringTimer-0");
        //the next run is scheduled during the previous run start
        timer.schedule(task1, 500, 3000);
        timer.schedule(task2, 500, 1500);

        TimeUnit.SECONDS.sleep(8);

        System.out.println("Done sleeping main for 5 sec");
        //if the below line is not called, the program executes for-ever
        timer.cancel();

        System.out.println(".... Ending Main .....");
    }

}
