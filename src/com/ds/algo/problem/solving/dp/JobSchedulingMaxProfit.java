package com.ds.algo.problem.solving.dp;

import java.util.Arrays;
import java.util.Comparator;

public class JobSchedulingMaxProfit {

    public static int calculateMaxProfit(int jobData[][] , int start) {
        int ans = 0;
        if(start >= jobData.length) {
            return 0;
        }
        int nextSuitableJobIndex = findNextNonOverlappingJob(jobData, start);
        if(nextSuitableJobIndex == -1) {
            ans = Math.max(jobData[start][2] , calculateMaxProfit(jobData , start + 1));
        } else {
            ans = Math.max(jobData[start][2] + calculateMaxProfit(jobData , nextSuitableJobIndex) ,
                    calculateMaxProfit(jobData , start + 1));
        }
        return ans;
    }


    public static int findNextNonOverlappingJob(int jobData[][] , int start) {
        int index = -1;
        for(int i = start;i<jobData.length;i++) {
            // new job start time must be greater than or equal to current job end time
            if(jobData[i][0] >= jobData[start][1]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int startTime[] = new int[]{1,2,3,4,6};
        int endTime[] = new int[]{3,5,10,6,9};
        int profit[] = new int[]{20,20,100,70,60};
        int jobData[][] = new int[startTime.length][3];
        for(int i = 0;i < startTime.length;i++) {
            jobData[i][0] = startTime[i];
            jobData[i][1] = endTime[i];
            jobData[i][2] = profit[i];
        }
//        for(int i = 0;i < startTime.length;i++) {
//            System.out.println("Starttime : " +  jobData[i][0] + "     Endtime : " + jobData[i][1] + "     Profit : " + jobData[i][2]);
//        }
        Arrays.sort(jobData , Comparator.comparingInt(o -> o[0]));
//        System.out.println("After Sorting");
//        for(int i = 0;i < startTime.length;i++) {
//            System.out.println("Starttime : " +  jobData[i][0] + "     Endtime : " + jobData[i][1] + "     Profit : " + jobData[i][2]);
//        }
        System.out.println(calculateMaxProfit(jobData , 0));

        // need to sort the data based on the start time an

    }
}
