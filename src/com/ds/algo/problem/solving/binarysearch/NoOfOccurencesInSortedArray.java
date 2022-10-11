package com.ds.algo.problem.solving.binarysearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfOccurencesInSortedArray {


    public static int search(int arr[]  , int ele) {
        int ans = -1;
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while(l <= h && (mid >= 0 && mid <= arr.length-1)) {
            mid = (l+h)/2;
            System.out.println(l +" " + mid + " " + h);
            if(arr[mid] == ele) {
                ans = mid;
                break;
            } else if(arr[mid] > ele) {
                h = mid -1;
            } else {
                l = mid + 1;
            }
        }

        // find last occurence in ans + 1 , high
        // find first occurence in low ,  ans-1
//        if(ans != -1) {
//            arr.
//        }

        return ans;

    }


    public static int searchFirstOccurence(int arr[] , int ele) {
        int ans = -1;
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while(l <= h && (mid >= 0 && mid <= arr.length-1)) {
            mid = (l + h)/2;
            System.out.println(l +" " + mid + " " + h);
            if(arr[mid] == ele) {
                ans = mid;
                h = mid - 1;
            } else if(arr[mid] > ele) {
                h = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Map<Integer , List<Integer>> map = new HashMap<>();

        int arr[] = new int[]{1,2,3,3,3,3,3,5,6,7,8};
        // int arr[] = new int[]{1,2,3,4,5};
        // System.out.println(search(arr , 2));
        System.out.println(searchFirstOccurence(arr , 3));
    }


}
