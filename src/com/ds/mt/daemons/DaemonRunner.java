package com.ds.mt.daemons;

public class DaemonRunner {

    //Daemon threads are for system tasks like monitoring the filesystem etc...
    public static void main(String[] args) {
        System.out.println("...STARTING main");

        Thread t1 = new Thread(new DaemonTask(1, 2, 1000)),
                t2 = new Thread(new DaemonTask(1, 2, 999)); //Daemon has more interval so once main thread t1 completes,
        //irrespective of the state of daemon thread status, it is killed by the JVM
        t2.setDaemon(true);
        t1.start();
        t2.start();

        System.out.println("Completed main ....");
    }

}

