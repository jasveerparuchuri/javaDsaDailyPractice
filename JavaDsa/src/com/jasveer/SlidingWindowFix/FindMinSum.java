package com.jasveer.SlidingWindowFix;

public class FindMinSum {
    public static void main(String[] args) {
        int[] arr = {100,200,300,400};
        System.out.println(findMin(arr,2));
    }

    private static int findMin(int[] arr, int k) {
        int i = 0,j = 0,sum =0;
        int min = Integer.MAX_VALUE;
        while(j < arr.length){
            sum += arr[j];
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                min  = Math.min(sum,min);
                sum -=arr[i];
                i++;
                j++;
            }
        }
        return  min;
    }
}
