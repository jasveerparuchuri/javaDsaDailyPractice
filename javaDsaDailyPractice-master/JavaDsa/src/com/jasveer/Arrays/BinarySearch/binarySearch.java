package com.jasveer.Arrays.BinarySearch;

public class binarySearch {
    public static void main(String[] args) {
        int[]  arr = {1,2,3,5,7,8,45,67,};
        System.out.println(Search(arr,45));
    }

     static int Search(int[] arr, int i) {
        int s = 0;
        int e = arr.length-1;
        while (s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == i){
                return mid;
            }else if(arr[mid] < i){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }

}
