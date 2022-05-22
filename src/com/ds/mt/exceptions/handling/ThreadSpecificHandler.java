
package com.ds.mt.exceptions.handling;

public class ThreadSpecificHandler {

    public static void main(String[] args) {
        SupportNotificationExceptionHandler supportNotificationExceptionHandler = new SupportNotificationExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(supportNotificationExceptionHandler);

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT"));
        new Thread(new ExceptionLeakingTask()).start();
        Thread t2 = new Thread(new ExceptionLeakingTask());
        new Thread(new ExceptionLeakingTask()).start();
        new Thread(new ExceptionLeakingTask()).start();

        t2.setUncaughtExceptionHandler(supportNotificationExceptionHandler);
        t2.start();
        throw new ArithmeticException("whatever");
    }
}

class SupportNotificationExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        notifySupport(t, e);
    }

    private void notifySupport(Thread t, Throwable e) {
        System.out.println("Notified support team on: " + e.getMessage() + " raised from : " + t.getName());
    }
}
