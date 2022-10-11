package com.tech.interviews;






public class Arcesium {

    public static void main(String[] args)  {
        String input = "-1,-2,-3";
        System.out.println(findLongestStreak(input));
    }

    private static int findLongestStreak(String input) {
        String str[] = input.split(",");
        int arr[] = new int[str.length];
        for(int i = 0 ; i < str.length;i++) {
            try {
                if(str[i].isEmpty()) {
                    return 0;
                }
                arr[i] = Integer.parseInt(str[i]);
            } catch (Exception e) {
                return 0;
            }
        }
        int ans = 0;
        int currSum = Integer.MIN_VALUE;
        int currMax = 0;
        int negativeCount = 0;
        for(int i = 0;i < arr.length;i++) {
            if(arr[i] < 0) {
                negativeCount++;
            }
            currMax = currMax + arr[i];
            if(currMax > currSum) {
                currSum = currMax;
            }
            if(currMax < 0) {
                currMax = 0;
            }
        }
        ans = currSum;
        if(negativeCount == arr.length) {
            return 0;
        }
        return ans;
    }
}
