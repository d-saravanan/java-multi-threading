package com.ds.mt.callables;

public class TaskResult<T> {
    T result;
    CallableTask task;

    public TaskResult(T result, CallableTask task) {
        this.result = result;
        this.task = task;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public CallableTask getTask() {
        return task;
    }

    public void setTask(CallableTask task) {
        this.task = task;
    }
}
