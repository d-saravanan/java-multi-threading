package com.ds.mt.exceptions.handling;

import com.ds.mt.threading.techniques.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.String.format;

public class ExecutorServiceExceptionHandlers {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT"));
        ExecutorService svc = Executors.newFixedThreadPool(8);
        svc.execute(new ExceptionLeakingTask());
        svc.execute(new ExceptionLeakingTask());
        svc.execute(new ExceptionLeakingTask());
        svc.execute(new ExceptionLeakingTask());

        ExecutorService service = Executors.newCachedThreadPool(new ExceptionHandlingThreadFactory());
        service.execute(new ExceptionLeakingTask());
        service.execute(new ExceptionLeakingTask());
        service.execute(new ExceptionLeakingTask());
        service.execute(new ExceptionLeakingTask());

        svc.shutdown();
        service.shutdown();
    }
}

class ExceptionHandlingThreadFactory extends NamedThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        ct++;
        Thread t = new Thread(r, format("%s%d", name, ct));
        t.setUncaughtExceptionHandler((t1, e) -> System.out.println("Handling the exception in factory for thread: " + t1.getName() + " and exception is: " + e.getMessage()));
        return t;
    }
}
