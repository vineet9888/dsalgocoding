package com.ds.algo.problem.solving.Arrays;

public class MergeSortPseudo {

    public static void main(String[] args) {
        int arr[] = new int[]{ 5,4,3,3,1};

        for(int i = 0 ; i <arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        sort(arr , 0 , arr.length-1);
        System.out.println("");
        for(int i = 0 ; i <arr.length;i++) {
            System.out.print(arr[i] + " ");
        }

    }


    public static void sort(int arr[] , int l , int h) {
        if(l == h) {
            return;
        }
        if(l < h) {
            int mid = (l + h)/2;
            System.out.println(l + " - " + h);
            sort(arr , l , mid);
            sort(arr , mid+1  , h);
            merge(arr , l , mid , mid+1, h);
        }


    }


    // 1 2 3     4 5 6
    public static void merge(int arr[] , int fl , int fh , int sl , int sh) {
        int first[] = new int[fh-fl+1];
        int second[] = new int[sh-sl+1];
        int k = 0;
        int i = fl;
        while(i <= fh) {
            first[k] = arr[i];
            i++;
            k++;
        }

        i = sl;
        k = 0;
        while(i <= sh) {
            second[k] = arr[i];
            i++;
            k++;
        }

        i = 0;
        int j = 0;
        k = fl;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                arr[k] = first[i];
                i++;
                k++;
            } else {
                arr[k] = second[j];
                j++;
                k++;
            }
        }


        while(i < first.length) {
            arr[k] = first[i];
            i++;
            k++;
        }

        while(j < second.length) {
            arr[k] = second[j];
            j++;
            k++;
        }
    }


}
