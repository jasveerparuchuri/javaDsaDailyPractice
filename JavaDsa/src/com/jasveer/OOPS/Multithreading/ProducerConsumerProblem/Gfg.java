package com.jasveer.OOPS.Multithreading.ProducerConsumerProblem;

public class Gfg {
    int buffer;
    boolean flag = false;
    public synchronized void produce(int item) throws InterruptedException {
        if(flag == true){
            wait();
        }
        buffer = item;
        System.out.println("Produce item : +"+ buffer);
        flag = true;
        notify();


    }
    public synchronized int consume() throws InterruptedException {
        if(flag == false){
            wait();
        }
        System.out.println("Consumed item : +"+ buffer);
        flag = false;
        notify();
        return buffer;
    }
}
