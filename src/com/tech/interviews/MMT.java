package com.tech.interviews;

public class MMT {

    public static void main(String[] args) {
        String first[] = new String[26];
        String second[] = new String[26];
        String third[] = new String[26];
        char ch = (char) 97;
        int start = 97;
        char ch1 = (char) 65;
        for(int i = 0 ; i < 26;i++) {
            first[i] = String.valueOf((i + 1));
            second[i] = String.valueOf((char) (97+i));
            third[i] =String.valueOf((char) (65+i));
        }

        Printer printer = new Printer(PlayerType.FIRST);
        Player firstPlayer = new Player(first , PlayerType.FIRST , printer);
        Player secondPlayer = new Player(second , PlayerType.SECOND , printer);
        Player thirdPlayer = new Player(third , PlayerType.THIRD , printer);
        firstPlayer.start();
        secondPlayer.start();
        thirdPlayer.start();

//        char arr[] = new char[]{'A','B','C'};
//        printAllPermurations(arr , 0);
    }

    public static void printAllPermurations(char arr[] , int start) {

        if(start == arr.length) {
            for(int i = 0 ; i < arr.length;i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < arr.length;i++) {
            swap(arr , start , i);
            printAllPermurations(arr , start + 1);
            swap(arr , i , start);
        }

    }

    public static void swap(char arr[] , int a , int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}

class Player extends Thread {

    String arr[];
    PlayerType playerType;
    Printer printer;

    public Player(String arr[] , PlayerType playerType , Printer printer) {
        this.arr = arr;
        this.playerType = playerType;
        this.printer = printer;
    }

    @Override
    public void run(){
        if(playerType.equals(PlayerType.FIRST)) {
            int i = 0;
            while(i < arr.length) {
                try {
                    printer.printFirst(arr[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } else if(playerType.equals(PlayerType.SECOND)) {
            int i = 0;
            while(i < arr.length) {
                try {
                    printer.printSecond(arr[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } else {
            int i = 0;
            while(i < arr.length) {
                try {
                    printer.printThird(arr[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}

class Printer {

    private volatile PlayerType initialState;
    public Printer(PlayerType initialState) {
        this.initialState = initialState;
    }

    public synchronized void printFirst(String ch) throws InterruptedException {
        while(!initialState.equals(PlayerType.FIRST)) {
            wait();
        }
        System.out.print(ch);
        initialState = PlayerType.SECOND;
        notifyAll();
    }

    public synchronized void printSecond(String ch) throws InterruptedException {
        while(!initialState.equals(PlayerType.SECOND)) {
            wait();
        }
        System.out.print(ch);
        initialState = PlayerType.THIRD;
        notifyAll();
    }

    public synchronized void printThird(String ch) throws InterruptedException {
        while(!initialState.equals(PlayerType.THIRD)) {
            wait();
        }
        System.out.println(ch);
        initialState = PlayerType.FIRST;
        notifyAll();
    }
}

enum PlayerType {
    FIRST,
    SECOND,
    THIRD;
}
