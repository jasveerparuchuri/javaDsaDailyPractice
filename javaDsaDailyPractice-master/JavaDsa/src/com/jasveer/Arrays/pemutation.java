package com.jasveer.Arrays;
import java.util.*;
public class pemutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> l  =permute(nums);
        for(List<Integer> i : l){
            System.out.println(i);
        }

    }public static List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        boolean[] b= new boolean[nums.length];
        List<List<Integer>>  ans= new ArrayList<>();
        backtrack(nums,b,ans,l);
        return ans;
    }
    public static void backtrack(int[] nums,boolean[] used, List<List<Integer>> ans,List<Integer> l){
        if(l.size() == nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int j =0;j < nums.length; j++){
            if(!used[j]){
                l.add(nums[j]);
                used[j] = true;
                backtrack(nums,used,ans,l);
                used[j] = false;
                l.remove(l.size()-1);
            }
        }
    }
}
