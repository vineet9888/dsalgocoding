package com.ds.algo.problem.solving.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

public class NoOfFactors {

    public static List<Integer> printDivisors(int n)  {
        TreeSet<Integer> set  = new TreeSet<>();
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i==0) {
                if (n/i == i) {
                    set.add(i);
                } else {
                    set.add(i);
                    set.add(n/i);
                }
            }
        }
        return set.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        List<Integer> list = printDivisors(100);
//        System.out.println(list);
//        int p = 5;
//        int ans = 0;
//        if(p <= list.size()) {
//            ans = list.get(p-1);
//        }
//        System.out.println(ans);

        printDivisors1(100);
    }

    // method to print the divisors
    static void printDivisors1(int n)
    {
        // Vector to store half of the divisors
        List<Integer> v = new ArrayList<>();
        int count = 1;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // check if divisors are equal
                if (n / i == i) {
                    System.out.print(" " +  i);
                    count++;
                } else {
                    System.out.print(" " + i);
                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }

        System.out.println(v);
        // The vector will be printed in reverse
//        for (int i = v.size() - 1; i >= 0; i--) {
//            System.out.printf(" il " + v.get(i));
//        }

    }
}
