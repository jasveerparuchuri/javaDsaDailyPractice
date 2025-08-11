package com.jasveer.OOPS;

public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;

        try{
            divide(a,b);
            int c =  a/a;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }finally{ // you cannot use finally without try block
            System.out.println("even exe ception is thrown or not it will executed if we use try");
        }

    }
    public static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException();
        }
        return a/b;
    }



}
