package com.ds.algo.problem.solving.dp;

public class StoneGame3 {

    public static int playStoneGame(int[] stoneValue , int index , int dp[]) {
        int ans = 0;

        if(index > stoneValue.length -1) {
            return 0;
        }

        if(dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }

        int firstCase = stoneValue[index] - playStoneGame(stoneValue , index+1 , dp);
        int secondCase = stoneValue[index] + getIndexValue(stoneValue,index+1) - playStoneGame(stoneValue , index + 2 , dp);
        ans = Math.max(firstCase , secondCase);
        int thirdCase = stoneValue[index] + getIndexValue(stoneValue,index+1) + getIndexValue(stoneValue,index+2)- playStoneGame(stoneValue , index + 3 , dp);
        ans = Math.max(ans , thirdCase);
        dp[index] = ans;
        // store result here.... in a DP array....dp[index] = ans;
        return ans;
    }



    public static int getIndexValue(int stoneValue[] , int index) {
        return stoneValue.length > index ? stoneValue[index] : 0;
    }


    public static String stoneGameIII(int[] stoneValue) {

        int dp[] = new int[50001];
        for(int i = 0;i<50001;i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        int ans = playStoneGame(stoneValue , 0 , dp);
        if(ans == 0) {
            return "Tie";
        } else if(ans < 0) {
            return "Bob";
        } else {
            return "Alice";
        }
    }


    public static int stoneGame2(int stoneValue[] , int m , int index , int turn) {
        if(index > stoneValue.length - 1) {
            return 0;
        }
        int ans = 0;
        if(turn % 2 == 0) {
            int max = -1;
            for(int i = 1;i <= 2*m;i++) {
                // from here we have to return the MAX...
                int moveValue = stoneGame2(stoneValue , Math.max(m , i) , index + i , turn + 1) + valueTillIndex(stoneValue , index , index + i);
                max = Math.max(max , moveValue);
            }
            ans = max;
        } else {
            // assume BOB will make his optimal move.... ie he will select the highest value of X
            ans = stoneGame2(stoneValue , Math.max(m , 2*m) , index + 2*m , turn + 1);
        }
        return ans;
    }

    public static int valueTillIndex(int arr[] , int startIndex , int endIndex) {
        int sum = 0;
        if(startIndex < arr.length && endIndex-1 < arr.length && startIndex <= endIndex) {
            for(int i = startIndex; i < endIndex;i++) {
                sum += arr[i];
            }
        }
        return sum;
    }


    public static int stoneGameII(int stoneValue[] , int m , int index , int dp[][]) {
        int size = stoneValue.length;
        if(index >= size) {
            return 0;
        }
        if(dp[index][m] != Integer.MIN_VALUE) {
            return dp[index][m];
        }
        int ans = Integer.MIN_VALUE;
        int sumTillNow = 0;
        for(int i = 0 ; i < 2*m;i++) {
            sumTillNow +=  (index+i)<size ?  stoneValue[index + i] : 0;
            int moveValue =  sumTillNow - stoneGameII(stoneValue , Math.max(i + 1 , m) , index + i + 1 , dp);
            ans = Math.max(ans ,moveValue) ;
        }
        dp[index][m] = ans;
        return dp[index][m];
    }

    public static void main(String[] args) {
        int stoneValue[] = new int[]{1,2,3,4,5,100};
        int dp[][] = new int[101][202];
        for(int i = 0 ; i < dp.length;i++) {
            for(int j = 0 ; j < dp[0].length;j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int sum = 0;
        for(int i = 0;i<stoneValue.length;i++) {
            sum += stoneValue[i];
        }
        int diff = stoneGameII(stoneValue , 1 , 0 , dp);
        System.out.print((diff + sum)/2);

    }
}
