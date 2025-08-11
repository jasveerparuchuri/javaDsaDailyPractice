package com.jasveer.OOPS.Multithreading;

public class Main {
    public static void main(String[] args) {
//        MainC t1  = new MainC();
//        t1.start();
        MainI temp = new MainI();
        Thread t2 = new Thread(temp);
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
