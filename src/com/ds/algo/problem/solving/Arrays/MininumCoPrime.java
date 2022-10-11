package com.ds.algo.problem.solving.Arrays;

import java.util.HashSet;
import java.util.Set;


public class MininumCoPrime
{
    static int MAXN = 1000001;
    static int[] spf = new int[MAXN];
    static int[] hash1 = new int[MAXN];

    static void sieve()
    {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;

        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;


        for (int i = 3; i * i < MAXN; i++)
        {

            if (spf[i] == i)
            {
                for (int j = i * i; j < MAXN; j += i)


                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    // Function to store the prime factors after dividing
    // by the smallest prime factor at every step
    static void getFactorization(int x)
    {
        int temp;
        while (x != 1)
        {
            temp = spf[x];
            if (x % temp == 0)
            {
                // Storing the count of
                // prime factors in hash
                hash1[spf[x]]++;
                x = x / spf[x];
            }
            while (x % temp == 0)
                x = x / temp;
        }
    }


    static boolean checkFactorization(int x)
    {
        int temp;
        while (x != 1)
        {
            temp = spf[x];
            if (x % temp == 0)
            {
                if(hash1[spf[x]] != 0) {
                    return false;
                }
                // hash1[spf[x]]++;
                x = x / spf[x];
            }
            while (x % temp == 0)
                x = x / temp;
        }
        return true;
    }

    static boolean check(int x)
    {
        int temp;
        while (x != 1) {
            temp = spf[x];

            if (x % temp == 0 && hash1[temp] > 1)
                return false;
            while (x % temp == 0)
                x = x / temp;
        }
        return true;
    }

    static int hasValidNum(int []arr, int n)
    {
        sieve();
        for (int i = 0; i < n; i++)
            getFactorization(arr[i]);

        int ans=0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for(int i = 2;i <MAXN;i++ ) {

            if(!set.contains(i)) {
                if(checkFactorization(i)) {
                    ans = i;
                    break;
                }
            }
        }
        return ans;

    }

    // Driver code
    public static void main (String[] args)
    {
        int []arr = { 1,2,3,4 };
        int n = arr.length;
        System.out.println(hasValidNum(arr , n));

    }
}