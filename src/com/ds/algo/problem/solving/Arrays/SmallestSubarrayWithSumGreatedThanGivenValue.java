package com.ds.algo.problem.solving.Arrays;

public class SmallestSubarrayWithSumGreatedThanGivenValue {


    public static void main(String[] args) {
        subarryWithGivenSum();
    }

    public static int countGoodSubsequences(String word) {
        long modulo = 1000000007;

        String S = word;
        int N = S.length(), i;
        long res[] = new long[27];
        for( i = 0; i<N; i++)
        {
            int a = (int)S.charAt(i) - 97;
            res[a]++;
        }

        long ans = 1;
        for(int k = 0; k < 27; k++)
        {
            if(res[k] > 0)
            {
                ans = ans*(res[k])%modulo;
            }
        }
        return (int)(ans % modulo);

    }

    public static void subarryWithGivenSum() {
        int arr[] = new int[]{1, 4};
        int val = 0;
        int i = 0;
        int j = 1;
        int sum = arr[i];
        int len = arr.length;
        while(j < len && i < len && i <= j) {
            if(sum == val) {
                break;
            } else if(sum < val) {
                while(sum < val && j < len-1) {
                    sum += arr[j];
                    j++;
                }
            } else {
                while(sum > val) {
                    sum = sum - arr[i];
                    i++;
                }
            }
        }

        System.out.println(sum + " i , j " + i + " , " + j);
        return;



    }

    public static void smallestSubarrayWithSumGreatedThanGivenValue() {
        int arr[] = new int[]{1, 4, 45, 6, 0, 19};
        int i = 0;
        int j = 1;
        int len = arr.length;
        int sum = arr[i];
        int val = 51;
        int ans = Integer.MAX_VALUE;
        while(i <= j && i < len && j < len) {
            if(sum > val) {
                // try to shrink the window.. from the begining
                while(sum > val && i < len) {
                    ans = Math.min(ans , j - i);
                    sum = sum - arr[i];
                    i++;
                }
            } else {
                // try to expand the window from the end until sum < val
                while(sum <= val && j < len) {
                    sum += arr[j];
                    j++;
                }
                ans = Math.min(ans , j - i);
            }
        }

        System.out.println(ans);
    }


}
