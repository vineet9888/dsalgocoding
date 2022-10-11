package com.com.threading;

public class DaemonThread {

    public static void main(String[] args) {
        System.out.println("Main is started..");
        CustomThread firstThread = new CustomThread();
        firstThread.setDaemon(false);
        firstThread.setName("First Thread");
        System.out.println("is first thread daemon " + firstThread.isDaemon());
        CustomThread secondThread = new CustomThread();
        secondThread.setName("Second Thread");
        secondThread.setDaemon(false);
        System.out.println("is second thread daemon " + secondThread.isDaemon());
        firstThread.start();
        secondThread.start();
        System.out.println("Main is finished..");
    }
}


class CustomThread extends Thread {

    @Override
    public void run() {
        try {
            loop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loop() throws InterruptedException {
        for(int i = 0; i <= 100; i++) {
            Thread t = Thread.currentThread();
            String threadname = t.getName();
            if(threadname.equals("First Thread")) {
                Thread.sleep(1000);
            } else {
                Thread.sleep(1500);
            }
            System.out.println("i==" + i);
        }
    }
}