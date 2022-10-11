package com.ds.algo.problem.solving.AmazonPrepration;

import java.util.Arrays;

public class OLA {



    static final int mod = 1000000007;
    public static int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);

        int maxH = hCuts[0] - 0;
        int maxV = vCuts[0] - 0;
        int ans = 0;
        for(int i = 1 ; i < hCuts.length;i++) {
            maxH = Math.max(hCuts[i] - hCuts[i-1] , maxH);
        }
        maxH = Math.max(maxH , h - hCuts[hCuts.length-1]);
        for(int i = 1 ; i < vCuts.length;i++) {
            maxV = Math.max(vCuts[i] - vCuts[i-1] , maxV);
        }
        maxV = Math.max(maxV , w - vCuts[vCuts.length-1]);
        maxH = maxH %mod;
        maxV = maxV %mod;
        System.out.println((long)maxH*maxV);
        int res = (int) (((long) maxH * maxV) % mod);
        return res;
    }

    public static void main(String[] args) {
        int hC[] = new int[]{2};
        int vC[] = new int[]{2};
        int h = 1000000000;
        int v = 1000000000;
        System.out.println(maxArea(h , v , hC , vC));
    }
}
