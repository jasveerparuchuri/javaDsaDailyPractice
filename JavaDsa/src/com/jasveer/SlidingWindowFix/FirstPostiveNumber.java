package com.jasveer.SlidingWindowFix;
import java.util.ArrayList;
import  java.util.List;
public class FirstPostiveNumber {
    public static void main(String[] args) {
        int[] arr = { -12, 5, -7, 8, -15, 30, -16, 28,-1,-2,-3 };
        int k = 3;
        System.out.println(findFirstPos(arr,k));
    }
    public static List<Integer> findFirstPos(int[] arr, int k){
        int i = 0;
        int j = 0;
        List<Integer> pos = new ArrayList<>();
        List<Integer> ans  = new ArrayList<>();
        while(j < arr.length){
            if(arr[j] > 0){
                pos.add(arr[j]);
            }

            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(pos.isEmpty()){
                    ans.add(0);
                }else{
                    ans.add(pos.get(0));
                    if(!pos.isEmpty() && pos.get(0) ==  arr[i]){
                        pos.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
