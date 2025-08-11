package com.jasveer.Arrays.Sorting;

import java.util.Arrays;

public class SelctionSort {
    public static void main(String[] args) {
        int[] arr = {5,6,8,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int max = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }
}
