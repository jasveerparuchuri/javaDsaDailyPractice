package com.jasveer.Arrays.BinarySearch;

public class FloorofNumber {
    public static int floor(int[] arr, int target){
        if(target < arr[0]){
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
        return arr[end];


    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8,9,10};
        int target = 12;
        System.out.println(floor(arr, target));
    }
}
