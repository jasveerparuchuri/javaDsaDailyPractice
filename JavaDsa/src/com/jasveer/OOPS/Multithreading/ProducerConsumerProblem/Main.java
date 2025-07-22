package com.jasveer.OOPS.Multithreading.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        Gfg gfg = new Gfg();
        Producer p = new Producer(gfg);
        Consumer c = new Consumer(gfg);
        p.start();
        c.start();
    }
}
