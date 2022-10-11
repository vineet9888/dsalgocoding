package com.ds.algo.problem.solving.binarysearch;

public class SearchInRotatedSortedArray {


    public static void findPivotElement(int arr[]) {

        int l = 0;
        int h = arr.length - 1;
        int mid;
        int pivot=-1;
        while(l <= h) {
            mid = (l+h)/2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                pivot = mid;
                break;
            }
            if(arr[mid] < arr[h] && arr[mid] < arr[l]){
                // search in left part...
                h = mid -1;
            }
            else if(arr[mid] > arr[l] && arr[mid]>arr[h]) {
                // search in right part
                l = mid + 1;
            }
        }
        System.out.println(pivot);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,4,5,1,2};
        System.out.println(findMin(arr));


    }

    public static int findMin(int nums[]){
        int low = 0 ;
        int high = nums.length-1;

        // pivot elements next element will be the smallest
        int pivot = -1;

        if(nums.length == 2) {
            return Math.min(nums[0] , nums[1]);
        }else if(nums.length == 1) {
            return nums[0];
        }
        while(low <= high) {
            int mid =  (low + high)/2;
            if(low == high) {
                pivot = low;
                break;
            }
            if(high - low == 1) {
                pivot =  (nums[low] > nums[high]) ? low : high;
                break;
            }
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                pivot = mid;
                break;
            }
            else if(nums[mid] < nums[low]) {
                high = mid-1;
            } else if(nums[mid] > nums[high]) {
                low = mid +1;
            }
//            else {
//                low = mid+1;
//            }
        }
        //System.out.println(pivot);
        if(pivot == nums.length-1) {
            return nums[0];
        } else {
            return nums[pivot +1];
        }
    }



    public static int binarySearch(int pivotIndex , int target , int arr[]) {
        if(pivotIndex == -1) {
            return -1;
        }
        if(arr[pivotIndex] == target) {
            return pivotIndex;
        }
        if(arr[0] < target && arr[pivotIndex] > target) {

        } else if(arr[pivotIndex+1] < target && arr[arr.length-1] > target) {
            // search in right side of pivot
        }
        return -1;
    }
}
// 7,8,9,10,1,2,3,4,5,6,6
// 1 2 3 4 5 6 7
// 5, 6, 7, 8, 9, 10, 1, 2, 3
