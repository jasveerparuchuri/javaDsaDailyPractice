package com.jasveer.OOPS;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;



public class CustomArrayList {
    private int[] data;
    private static int default_size = 10;
    private int size = -1;
    CustomArrayList(){
        this.data = new int[default_size];
    }
    CustomArrayList(int size){
        this.data = new int[size];
    }
    public boolean add(int item){
        if(isFull()){
            resize();
        }
        data[++size] = item;
        return true;
    }

    public boolean isFull(){
        return size+1 == data.length;
    }

    public void resize(){
        int[] temp = new int[data.length * 2];
        for(int i = 0;i<data.length;i++){
            temp[i] = data[i];
        }
        data  =  temp;
    }
    public boolean isEmpty(){
        return size == -1;
    }
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("list is empty");
        }
        int removed = data[size--];
        return removed;
    }

    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void setAtIndex(int index,int value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) throws Exception {
        CustomArrayList list = new CustomArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        System.out.println(list);
        for(int i = 0;i<21;i++){
            list.add(i);
        }
        System.out.println(list.size());

    }
}
