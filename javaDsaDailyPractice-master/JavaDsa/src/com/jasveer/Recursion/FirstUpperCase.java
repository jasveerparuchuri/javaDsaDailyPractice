package com.jasveer.Recursion;
import java.util.*;
public class FirstUpperCase {
    public static void main(String[] args) {

        System.out.println(FirstUpperCaseLetter("jaSveER",0,'0'));
    }
    static char FirstUpperCaseLetter(String s ,int i,char c){
        if(s.isEmpty()){
            return c;
        }
        char ch = s.charAt(i);

        if(Character.isUpperCase(ch)){
            c = s.charAt(i);
            return  c;
        }
        return FirstUpperCaseLetter(s,i+1,c);
    }
}
