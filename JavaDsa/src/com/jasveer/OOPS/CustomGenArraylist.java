package com.jasveer.OOPS;


import java.util.Arrays;

public class CustomGenArraylist<T> {
    private Object[] data;
    private static int default_size = 10;
    private int size = -1;
    CustomGenArraylist(){
        this.data = new Object[default_size];
    }
    CustomGenArraylist(int  size){
        this.data = new Object[size];
    }
    public boolean add(T item){
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
        Object[] temp = new Object[data.length * 2];
        for(int i = 0;i<data.length;i++){
            temp[i] =  data[i];
        }
        data  =  temp;
    }
    public boolean isEmpty(){
        return size == -1;
    }
    public T remove() throws Exception {
        if(isEmpty()){
            throw new Exception("list is empty");
        }
        T removed = (T) data[size--];
        return (removed);
    }

    public T get(int index){
        return (T) data[index];
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

    public static void main(String[] args) {
        CustomGenArraylist<Integer> list = new CustomGenArraylist<>();
        list.add(9);
    }
}
