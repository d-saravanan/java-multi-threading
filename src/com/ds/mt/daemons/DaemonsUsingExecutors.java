package com.ds.mt.daemons;

import com.ds.mt.callables.CallableTask;
import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.String.format;

public class DaemonsUsingExecutors {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("...STARTING main");

        ExecutorService svc = Executors.newCachedThreadPool(new NamedDaemonThreads());

        svc.execute(new DaemonTask(1, 2, 300));
        svc.execute(new DaemonTask(1, 2, 799));
        svc.execute(new DaemonTask(1, 2, 999));
        svc.execute(new DaemonTask(1, 2, 499));

        //Daemon has more interval so once main thread t1 completes,
        //irrespective of the state of daemon thread status, it is killed by the JVM

        svc.shutdown();

        Thread.sleep(3400);

        System.out.println("Completed main ....");
    }
}

class NamedDaemonThreads extends NamedThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        ct++;
        Thread t = new Thread(r, format("%s%d", name, ct));
        t.setDaemon(ct % 2 == 0);
        return t;
    }
}