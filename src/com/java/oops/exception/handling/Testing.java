package com.java.oops.exception.handling;

import java.util.concurrent.Executor;

public class Testing {

    public static void main(String[] args) {
        Parent parent = getChildInstance();
        System.out.println(parent.getName());
        System.out.println(parent.getAge());
    }

    public static Parent getInstance() {
        Child child = new Child();
        return child;
    }

    public static Child getChildInstance() {
        Parent parent = new Parent("vineet sharma" , 27);
        return (Child) parent;
    }
}


interface ExecutorInterface extends Executor {

}


interface TaskExecutorInterface extends ExecutorInterface {

}