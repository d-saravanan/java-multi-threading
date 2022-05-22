package com.ds.mt.exceptions.handling;

public class ExceptionLeaking {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT"));
//        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("Exception raised from : " + t.getName() + " and exception is: " + e.getMessage()));
        try {
            new Thread(new ExceptionLeakingTask()).start();
            new Thread(new ExceptionLeakingTask()).start();
            new Thread(new ExceptionLeakingTask()).start();
            new Thread(new ExceptionLeakingTask()).start();
        } catch (Exception e) {
            //this catch block does not get executed as the exceptions are thrown inside threads (not the main thread)
            System.out.println("Executing the handler for the thread exceptions");
            e.printStackTrace();
        }
        throw new ArithmeticException("whatever");
    }
}

class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final String instanceId;

    public ThreadExceptionHandler(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception raised from : " + t.getName() + " inside instance: " + instanceId + " and exception is: " + e.getMessage());
    }
}

class ExceptionLeakingTask implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("Hello World!!!");
    }
}