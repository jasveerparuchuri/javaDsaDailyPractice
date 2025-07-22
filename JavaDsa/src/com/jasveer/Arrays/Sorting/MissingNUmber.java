package com.jasveer.Arrays.Sorting;

public class MissingNUmber {
    public static int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int current  = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[current]){
                int temp = arr[i];
                arr[i] = arr[current];
                arr[current] = temp;
            }else{
                i++;
            }
        }
        for(int j =0;j< arr.length;j++){
            if(arr[j] != j){
                return j;
            }
        }
        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr={4,3,2,0};
        System.out.println(missingNumber(arr));
    }
}
