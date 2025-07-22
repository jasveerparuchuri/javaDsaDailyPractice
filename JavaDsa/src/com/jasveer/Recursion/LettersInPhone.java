package com.jasveer.Recursion;

public class LettersInPhone {
    public static void main(String[] args) {
        String p = "23";
        PhoneNum(" ",p);
    }
    static void PhoneNum(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for(int i = (digit-2)*3;i< digit *3;i++){
            char ch = (char) ('a' + i);
            PhoneNum( p+ch,up.substring(1));
        }
    }
}
