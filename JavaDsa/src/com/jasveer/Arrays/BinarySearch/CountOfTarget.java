package com.jasveer.Arrays.BinarySearch;

public class CountOfTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 8, 9, 10};
        int target = 4;
        int first = firstOccu(arr,target);
        int last = lastOccu(arr,target);
        int total = last-first +1;
        System.out.println("Fist Occurence of target is : "+first);
        System.out.println("Last Occurence of target is : "+last);
        System.out.println("Total number target elements is :"+total);
    }

    static int lastOccu(int[] arr, int target) {
        int s = 0;
        int e = arr.length-1;
        int res = -1;
        while (s <= e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                res = mid;
                s = mid+1;
            }else if(arr[mid] < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return res;
    }

    static int firstOccu(int[] arr,int target){
        int s = 0;
        int e = arr.length-1;
        int res = -1;
        while (s <= e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                res = mid;
                e = mid-1;
            }else if(arr[mid] < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return res;
    }
}
