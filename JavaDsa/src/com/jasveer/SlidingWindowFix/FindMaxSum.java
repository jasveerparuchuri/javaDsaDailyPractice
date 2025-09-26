package com.jasveer.SlidingWindowFix;

public class FindMaxSum {
    public static void main(String[] args) {
        int arr[] = {100,200,300,400};
        System.out.println(findMax(arr,2));
    }


    public static int findMax(int[] arr,int k){
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(j<arr.length){
            if(j- i+1 < k){
                sum += arr[j];
                j++;
            }else if(j-i+1 == k){
                sum +=  arr[j];
                max = Math.max(sum,max);
                sum -= arr[i];
                j++;
                i++;
            }
        }
        return max;
    }

}
