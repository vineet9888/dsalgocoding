package com.interviews.system.design.jobexecutor;

public class Job implements IJob {

    @Override
    public void execute() {
        try {
            System.out.print("Starting job for thread : " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.print("Finishing job for thread : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
