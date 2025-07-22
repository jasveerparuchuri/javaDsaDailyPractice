package com.jasveer.OOPS.Comparing;

public class main {
    public static void main(String[] args) {
        Student jashu = new Student(1,98.0f);
        Student rahul = new Student(2,99.0f);
        if(jashu.compareTo(rahul) < 0){
            System.out.println("rahul marks are more ");
        } else if (jashu.compareTo(rahul) == 0) {
            System.out.println("equal");
        }
    }
}
