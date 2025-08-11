package com.jasveer.StackAndQueue;

import java.util.Queue;
import java.util.Stack;

public class main {
    public static void main(String[] args) throws Exception {
//        CustomStack  ds = new DynamicStack(7);
//        ds.push(1);
//        ds.push(1);
//        ds.push(2);
//        ds.push(3);
//        ds.push(4);
//        ds.push(5);
//        ds.push(6);
//        ds.push(7);
//        ds.push(6);
//        ds.push(7);
//        CustomQueue cs = new CustomQueue(5);
//        cs.insert(1);
//        cs.insert(2);
//        cs.insert(3);
//        cs.insert(4);
//        cs.insert(5);
//        cs.insert(5);
//        cs.insert(5);
//        cs.display();
//        cs.remove();
//        cs.remove();
//        cs.remove();
//        cs.remove();
//        cs.remove();
//
//        cs.display();


        CircularQueue queue = new CircularQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);

        queue.display();
















    }
}
