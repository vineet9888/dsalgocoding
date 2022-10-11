package com.interviews.system.design.jobexecutor;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread implements  Runnable {


    private Queue<IJob> queue;

    public WorkerThread(Queue<IJob> queue) {
        this.queue =  queue;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                IJob job = queue.poll();
                job.execute();
            }
        }
    }
}
