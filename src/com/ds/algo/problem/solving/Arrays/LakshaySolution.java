package com.ds.algo.problem.solving.Arrays;

public class LakshaySolution {

    public static int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }


    public static int solution(int N) {
        int sum = getSum(N);
        int ans = -1;
        while(N<=50000) {
            N++;
            if(sum == getSum(N)) {
                ans = N;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(28));
        System.out.println(solution(734));
        System.out.println(solution(1990));
        System.out.println(solution(1000));

    }
}
