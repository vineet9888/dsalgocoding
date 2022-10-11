package com.com.threading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class RateLimiter {

    public static void main(String[] args) {
//        CustomTask task1 = new CustomTask("Task1");
//        CustomTask task2 = new CustomTask("Task2");
//        task1.start();
//        task2.start();

        CustomRunnable runnable1 = new CustomRunnable(() -> printData());
        CustomRunnable runnable2 = new CustomRunnable(() -> printData());
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }

    public static String printData() {
        return Thread.currentThread().getName();
    }
}

class CustomRunnable <T> implements Runnable {

    Supplier<T> supplier;

    public CustomRunnable(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void run() {
        System.out.println(supplier.get());
    }
}

class InMemoryCache {

    private InMemoryCache() {
        throw  new RuntimeException("Instantiation now allowed");
    }

    static Map<String , String> map = new ConcurrentHashMap<>();

    public static String get(String name) {
        return map.get(name);
    }

    public static String put(String key , String value) {
        return map.put(key,value);
    }

    public static void remove(String key){
        map.remove(key);
    }

    public static Map<String ,String > getCache() {
        return map;
    }

}

class CustomTask extends Thread {
    String name;
    int counter = 0;
    public CustomTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(counter <= 4) {
            // System.out.println("Hello from : " + this.name);
            if(counter % 2 == 0 ) {
                String key = this.name+"_"+counter;
                InMemoryCache.put(key , key);
            } else {
                InMemoryCache.getCache().forEach((key , value) -> {
                    System.out.println(key + " -> " + value);
                });
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }
}
