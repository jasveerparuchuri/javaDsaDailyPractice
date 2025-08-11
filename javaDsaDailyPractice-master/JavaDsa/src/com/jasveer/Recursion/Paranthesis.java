package com.jasveer.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paranthesis {
    public static void main(String[] args) {
        System.out.println(paranRet(3,0,0,""));
    }
//    public static void paran(int n,int open, int close,String p){
//        if(p.length() == (n * 2)){
//            System.out.println(p);
//            return;
//        }
//        if( open < n){
//            paran(n,open+1,close,p +"(");
//        }
//        if(close < n){
//            paran(n,open,close+1,p+")");
//        }
//    }
    public static List<String> paranRet(int n, int open, int close, String p){
        if(p.length() == (n * 2)){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if( open < n){
            list.addAll(paranRet(n,open+1,close,p +"("));
        }
        if(close < open){
            list.addAll(paranRet(n,open,close+1,p+")"));
        }
        return list;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }


    private void backtracking(List<String> ans, StringBuilder currString, int open, int close, int n){
        if(currString.length() == 2*n){
            ans.add(currString.toString());
            return;
        }

        if(open < n){
            currString.append("(");
            backtracking(ans, currString, open+1, close, n);
            currString.deleteCharAt(currString.length()-1);
        }

        if(open > close){
            currString.append(")");
            backtracking(ans, currString, open, close+1, n);
            currString.deleteCharAt(currString.length()-1);
        }
    }

}
