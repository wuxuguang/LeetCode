package com.wxg.mysolution;

public class Problem4 {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length == 0 && B.length == 0)
     	   return 0;
        int[] help;
        if(A.length == 0)
     	   help = B;
        else if(B.length == 0)
     	   help = A;
        else{
     	   help = new int[A.length + B.length];
            int i=0;
            int j=0;
            int k=0;
            while(i<A.length && j<B.length){
         	   if(A[i] <= B[j])
         		   help[k++] = A[i++];
         	   else
         		   help[k++] = B[j++];
            }
            while(i<A.length)
         	   help[k++] = A[i++];
            while(j<B.length)
         	   help[k++] = B[j++];
        }     
        if(help.length%2 == 0)
     	   return (double)(help[help.length/2] + help[help.length/2-1])/2;
        else
     	   return (double)(help[help.length/2]);
     }
}
