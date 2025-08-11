package com.jasveer;

import java.util.ArrayList;
import java.util.List;


public class javaSubSet {
    public static void main(String[] args) {
        //AllSeqAscii(" ","abc");
        System.out.print(AllSeqRet(" ","abc"));
//        int[] arr = {1,2,3};
//        List<List<Integer>> ans = SubseqIte(arr);
//        for(List<Integer> list : ans){
//            System.out.print(list + " ");
//        }
//        AllSeq(" ","abc");
    }

    ///  code for subseq  values
//    public static  void AllSeq(String p , String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return ;
//        }
//        char ch  = up.charAt(0);
//        AllSeq(p + ch,up.substring(1));
//        AllSeq(p,up.substring(1));
//    }
//
//    ///  code for subseq returing values
    public static ArrayList<String> AllSeqRet(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list ;
        }
        char ch  = up.charAt(0);
        ArrayList<String> left = AllSeqRet(p + ch,up.substring(1));
        ArrayList<String> right = AllSeqRet(p,up.substring(1));
        left.addAll(right);
        return left ;
    }
//
//
//    ///  code for subseq Ascii values
//    public static  void AllSeqAscii(String p , String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return ;
//        }
//        char ch  = up.charAt(0);
//        AllSeqAscii(p + ch,up.substring(1));
//        AllSeqAscii(p,up.substring(1));
//        AllSeqAscii(p + (ch+0), up.substring(1));
//
//    }


    /// code for subseq iterator
//    public static List<List<Integer>> SubseqIte(int[] arr){
//        List<List<Integer>> outer = new ArrayList<>();
//        outer.add(new ArrayList<>());
//        for(int num:arr){
//            int n = outer.size();
//            for(int i = 0;i < n;i++){
//                List<Integer> internal = new ArrayList<>(outer.get(i));
//                internal.add(num);
//                outer.add(internal);
//            }
//        }
//        return outer;
//    }
}
