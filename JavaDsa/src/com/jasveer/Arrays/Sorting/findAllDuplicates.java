package com.jasveer.Arrays.Sorting;

import java.util.ArrayList;
import java.util.List;

public class findAllDuplicates {
    public static  List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct] ){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }
        for(int j =0 ;j <arr.length;j++){
            if(arr[j] != j+1){
                list.add(arr[j]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {5,6,7,7,9,8,9,2,4,2,3};
        System.out.println(findDuplicates(arr));

    }
}
