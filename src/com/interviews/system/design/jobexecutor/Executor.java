package com.interviews.system.design.jobexecutor;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Executor {

    private int threadCount;

    Queue<IJob> queue = new LinkedBlockingQueue<>();

    public Executor(int threadCount) {
        this.threadCount = threadCount;
        this.initializeThreadPool();
    }

    public void initializeThreadPool() {
        for(int i = 0 ; i < threadCount;i++) {
            WorkerThread thread = new WorkerThread(queue);
            thread.run();
        }

    }



    public void submit(IJob job) {
        queue.add(job);
    }



}
