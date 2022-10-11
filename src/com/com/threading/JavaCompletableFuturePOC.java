package com.com.threading;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class JavaCompletableFuturePOC {

    public static void main(String[] args) {
        //Thread fetchOrders = new DBCall("fetchOrders" , 4000L);
        // Thread fetchProducts = new DBCall("fetchProducts" , 5000L);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        DatabaseOperation fetchOrders = new DatabaseOperation(4000L , "fetchOrders");
        DatabaseOperation fetchProducts = new DatabaseOperation(5000L , "fetchProducts");

        //fetchOrders.execute();
        //fetchProducts.execute();
        List<CompletableFuture<String>> futures = new ArrayList<>();

        futures.add(CompletableFuture.supplyAsync(() -> {
            return fetchOrders.execute();
        } , executor));
        futures.add(CompletableFuture.supplyAsync(() -> {
           return fetchProducts.execute();
        } , executor));

        for (CompletableFuture<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        //fetchOrders.start();
        //fetchProducts.start();
    }
}


class DatabaseOperation {

    private Long delay;
    private String operationName;
    public DatabaseOperation(Long delay , String operationName) {
        this.delay = delay;
        this.operationName = operationName;
    }

    public String execute() {
        try {
            System.out.println(String.format("Started making a db call for operation : %s in thread : %s" , operationName , Thread.currentThread().getName()));

            Thread.sleep(this.delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("DB call for operation : %s in thread : %s is completed" , operationName , Thread.currentThread().getName()));
        return "Operation : " + operationName +" is success";
    }
}





class DBCall extends Thread {

    private String name;
    private Long delay;

    public DBCall(String name , Long delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        System.out.println("Started making a db call for thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(this.delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Records are fetched from the database for thread : " + Thread.currentThread().getName());
    }
}