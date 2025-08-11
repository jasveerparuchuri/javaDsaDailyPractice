package com.jasveer.Recursion;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
//        maze(" ",3,3);
        System.out.println(mazeRetDia(" ",3,3));
    }
//    public static void maze(String p,int r,int c){
//        if(r == 1 && c == 1){
//            System.out.println(p);
//             return ;
//        }
//        if(r >1) {
//            maze(p + "D", r - 1, c);
//        }
//        if(c>1) {
//            maze(p + "r", r, c - 1);
//        }
//
//    }

//    public static ArrayList<String> mazeRet(String p, int r, int c){
//        if(r == 1 && c == 1){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> arr = new ArrayList<>();
//
//        if(r >1) {
//            arr.addAll(mazeRet(p + "D", r - 1, c));
//        }
//        if(c>1) {
//            arr.addAll(mazeRet(p + "r", r, c - 1));
//        }
//        return arr;
//    }
    public static ArrayList<String> mazeRetDia(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> arr = new ArrayList<>();

        if(r >1 || c >1 ){
            arr.addAll(mazeRetDia(p + "D", r - 1, c-1));
        }
        if(r >1) {
            arr.addAll(mazeRetDia(p + "H", r - 1, c));
        }
        if(c>1) {
            arr.addAll(mazeRetDia(p + "V", r, c - 1));
        }
        return arr;
    }
}
