package com.com.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class JavaFutures {

    public static void main(String[] args) {

        System.out.println("This is the start of my main method");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello World from thread : " + Thread.currentThread().getName());
            return "return this from future";
        }).thenApply((s -> {
            return s + " appended something here";
        }));
        System.out.println("this is the end of mu main method");
        if(!future.isDone()) {
            try {
                String data = future.get();
                System.out.println(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
