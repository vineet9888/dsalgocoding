package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PaloAlto {

    public static void maxNum(int num) {
        List<Integer> arr = new ArrayList<>();
        while(num > 0) {
            int temp = num % 10;
            num = num /10;
            arr.add(temp);
        }
        // 6 4 3 5

        // (0-0) + digit + (1-(n-1))
        // 3 4 5 7 8 9
        // 3 4 5 = 5 4 3
        // 678 = 8 7 6
        // 876
        int pow = arr.size() + 1;
        List<Integer> newList = new ArrayList<>();



        System.out.println(arr);
    }

//    public static int getNumberAfterOperation(List<Integer> arr , int start , int end) {
//
//    }


    public static int power(int base , int power) {
        int ans = 1;
        for(int i = 0 ; i < power;i++) {
            ans *= base;
        }
        return ans;
    }

    public static int getDecimalFromList(List<Integer> arr , boolean isNegative) {
        int ans = 0;
        for(int i = 0 ;i < arr.size();i++) {
            ans += power(10 , i) * arr.get(i);
        }

        return isNegative ?  ans*-1 : ans;
    }

    public static void main(String[] args) {

        // maxNum(345);

        int n = -6789;
        boolean isNegative = n < 0;
        List<Integer> list = new ArrayList<>();
        if(isNegative) {
            n = n*-1;
        }
        while(n > 0) {
            int temp = n % 10;
            list.add(temp);
            n = n / 10;
        }
        int digit = 5;
        // 1 2 3 4 5
        int max = isNegative ? Integer.MIN_VALUE : -1;
        for(int i = 0 ; i <= list.size();i++) {
            List<Integer> ans = new ArrayList<>();
            int low = 0;
            int mid = i;
            int high = list.size();
            if(low <= mid) {
                List<Integer> temp = list.subList(low , mid);
                if(!temp.isEmpty()) {
                    ans.addAll(temp);
                }
            }
            ans.add(digit);
            if(high >= mid) {
                List<Integer> temp = list.subList(mid , high);
                if(!temp.isEmpty()) {
                    ans.addAll(temp);
                }
            }
            System.out.println(ans +" -> " + getDecimalFromList(ans , isNegative));
            max = Math.max(getDecimalFromList(ans , isNegative) , max);
        }
        System.out.println(max);


    }


    public static int stablePeriods(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            int length = 0;
            int diff = nums[i] - nums[i - 1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] != diff) break;
                length++;
            }
            ans += (length * (length + 1))/2;
            i += length;
        }
        return ans;
    }






    public static int maxNum(int num, int digit)
    {
        // edge case
        if (num == 0)
        {
            return digit * 10;
        }

        // -1 if num is negative number else 1
        int negative = num / Math.abs(num);
        // get the absolute value of given number
        num = Math.abs(num);
        int n = num;
        // maximum number obtained after inserting digit.
        int maxVal = Integer.MIN_VALUE;
        int counter = 0;
        int position = 1;

        // count the number of digits in the given number.
        while (n > 0)
        {
            counter++;
            n = n / 10;
        }

        // loop to place digit at every possible position in the number,
        // and check the obtained value.
        for (int i = 0; i <= counter; i++)
        {
            int newVal = ((num / position) * (position * 10)) + (digit * position) + (num % position);

            // if new value is greater the maxVal
            if (newVal * negative > maxVal)
            {
                maxVal = newVal * negative;
            }

            position = position * 10;
        }

        return maxVal;
    }
}