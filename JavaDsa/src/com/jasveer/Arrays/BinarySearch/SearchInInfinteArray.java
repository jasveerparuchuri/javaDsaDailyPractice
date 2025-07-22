package com.jasveer.Arrays.BinarySearch;

public class SearchInInfinteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int k = 10;
        System.out.println(answer(arr , k));
    }
    public static int answer(int[] arr,int target){
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            start = end+1;
            // doubling small box of array in infinite array
            end =  end *2;

        }
        return binarySearch(arr,target,start,end);
    }
    public static int binarySearch(int[] arr,int target,int start, int end){
        int s = start;
        int e = end;
        while (s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }
}
