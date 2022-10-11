package com.com.threading;

public class PrintEvenOdd {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread even = new Task(20 , false , printer);
        Thread odd  = new Task(20 , true , printer);
        even.start();
        odd.start();

    }

}

class Task extends Thread {

    public final int MAX_VALUE;
    public boolean isOdd;
    public Printer printer;
    public int initialValue;
    
    Task(int maxValue , boolean isOdd , Printer printer) {
        super(isOdd ? "Odd Thread" : "Even Thread");
        this.MAX_VALUE = maxValue;
        this.isOdd = isOdd;
        this.printer = printer;
        this.initialValue = this.isOdd ? 1 : 2;
    }
    
    @Override
    public void run() {
        while(this.initialValue <= MAX_VALUE) {
            if(isOdd) {
                printer.printOdd(this.initialValue);
                this.initialValue = this.initialValue + 2;

            } else {
                printer.printEven(this.initialValue);
                this.initialValue  = this.initialValue + 2;
            }
        }
    }
}


class Printer {

    public volatile boolean printOdd = true;

    public synchronized  void printOdd(int value) {
        while(!printOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + value);
        printOdd = false;
        notify();
    }

    public synchronized void printEven(int value) {
        while(printOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +  " : " + value);
        printOdd = true;
        notify();

    }
}