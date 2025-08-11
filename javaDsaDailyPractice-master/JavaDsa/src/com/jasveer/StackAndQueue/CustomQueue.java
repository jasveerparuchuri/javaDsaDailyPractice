package com.jasveer.StackAndQueue;

import java.sql.SQLOutput;

public class CustomQueue {
    protected int[] data;
    private static final int  DEAFULT_SIZE = 10;

    int end = 0;

    CustomQueue(){
        this(DEAFULT_SIZE);
    }
    public  CustomQueue(int size){

        this.data = new int[size];
    }


    public boolean isFull(){
        return end == data.length;
    }

    public boolean isEmpty(){
        return end  == 0;
    }

    public boolean insert(int  item){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw  new Exception("Queue is Empty!");
        }
        int removed = data[0];
        for (int i =1;i<end;i++){
            data[i-1]  = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw  new Exception("Queue is Empty!");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i <end ; i++) {
            System.out.print(data[i]+" <-");
        }
        System.out.println("End");
    }
}
