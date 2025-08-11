package com.jasveer.Arrays.BinarySearch;

public class LastOcc {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 8, 9, 10};
        System.out.println(search(arr, 4));
    }
    static int search(int[] arr, int target){
        int s  = 0;
        int e = arr.length-1;

        int res = -1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                res = mid;
                s = mid + 1;
            }
            else if (arr[mid] < target) {
                s = mid + 1; // Go right
            }
            else {
                e = mid - 1; // arr[mid] > target → must go left
            }
        }
        return res;
    }
}
