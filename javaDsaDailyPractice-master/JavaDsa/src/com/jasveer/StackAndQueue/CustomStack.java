package com.jasveer.StackAndQueue;



public class CustomStack {

    protected int[] data;
    private static final int  DEAFULT_SIZE = 10;

    int ptr = -1;

    CustomStack(){
        this(DEAFULT_SIZE);
    }
    public  CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()){
            throw  new Exception(" You cannot pop item from empty stack");
        }
        return data[ptr--];
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw  new Exception(" You cannot peek item from empty stack");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length-1;
    }

    public boolean isEmpty(){
        return ptr  == -1;
    }
}
