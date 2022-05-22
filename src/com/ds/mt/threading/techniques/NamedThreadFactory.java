package com.ds.mt.threading.techniques;

import java.util.concurrent.ThreadFactory;

import static java.lang.String.format;

public class NamedThreadFactory implements ThreadFactory {
    protected static int ct = 0;
    protected String name = "My_NamedThread_";

    @Override
    public Thread newThread(Runnable r) {
        ct++;
        return new Thread(r, format("%s%d", name, ct));
    }
}
