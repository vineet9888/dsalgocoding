package com.ds.algo.problem.solving.Arrays;

import java.util.*;

public class Inkblot {

    private final int age;

    Inkblot(int age) {
        String s = "asd";

        this.age = age;
    }

    public static void test1() {

    }

    public static void test() {
        int count = 0;
        int a = 3;
        main(null);
        while(count++ < 3) {
            int b = (1+2*count)%3;
            switch (b) {
                default:
                    case 0: a -=1 ; break;
                    case 1: a+= 5;
            }
        }
        System.out.println("asd "  + a);
    }

    public static void main(String[] args) {
        test1();
        main(null);
        String input = "23 + inkblot7=70";
        String first = null;
        String second = null;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < input.length();i++) {
            if(input.charAt(i) == 'i' ) {
                if(input.substring(i , i + 7).equals("inkblot")) {
                    first = input.substring(0,i);
                    second = input.substring(i+7 , input.length());
                    break;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();



        int nums[] = new int[]{};
        Arrays.asList(nums);


        System.out.println(first + " -  " + second);
        System.out.println(Character.toLowerCase('B'));
        System.out.println(Character.toLowerCase('b'));
        String ss ="vin sh";
        if(ss.charAt(3) == ' ') {
            System.out.println(" space hai");
        } else {
            System.out.println(" no space");
        }
        char character = 'A';
        int ascii = (int) character;
        System.out.println(ascii);

    }
}
