package com.jasveer.Arrays.BinarySearch;

public class CelingOfNumber {
    public static int celing(int[] arr, int target){
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start <=end){
            int mid = start +(end-start)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid]>target) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return arr[start];


    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8,9,10};
        int target = 11;
        System.out.println(celing(arr, target));
    }

}
