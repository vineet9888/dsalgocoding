package com.ds.algo.problem.solving.dp;

public class Solution {
    static long mod=(long)((long)Math.pow(10,9)+(long)7 );
    static long maxx(int n,int m,int k,int mm){
        if(k==0 && n==0){
            return 1;
        }
        if(n==0){return 0;}
        System.out.println(n+ " " + m + " " + k + " " + mm);
        if(aa[n][k][mm]!=-1){
            return aa[n][k][mm];
        }
        long tot=0;
        if(k==0){
            for(int j=1;j<=mm;j++){
                tot=(long)((long)tot+(long)maxx(n-1,m,k,mm))%(long)mod;
            }
            return aa[n][k][mm]=tot;
        }else{
            for(int j=1;j<=m;j++){
                if(j>mm){
                    tot=(long)((long)tot+(long)maxx(n-1,m,k-1,j))%(long)mod;

                }else{
                    tot=(long)((long)tot+(long)maxx(n-1,m,k,mm))%(long)mod;
                }
            }
            return aa[n][k][mm]=tot;
        }
    }
    static long[][][] aa;
    public static int numOfArrays(int n, int m, int k) {
        aa=new long[n+1][k+1][m+1];
        for(int j=0;j<aa.length;j++){
            for(int i=0;i<aa[0].length;i++){
                for(int l=0;l<aa[0][0].length;l++){
                    aa[j][i][l]=-1;
                }
            }
        }
        return (int)maxx(n,m,k,0);
    }

    public static void main(String[] args) {
        System.out.print(numOfArrays(2,3,1));
    }
}
