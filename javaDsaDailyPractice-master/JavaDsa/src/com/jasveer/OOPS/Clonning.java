package com.jasveer.OOPS;

public class Clonning  implements Cloneable{
    int age;
    String name;
    public Clonning(int age , String name) {
        this.age = age;
        this.name  = name;
    }
    public Clonning(Clonning other){
        this.age = other.age;
        this.name = other.name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Clonning cs = new Clonning(18,"jasveer");
//        Clonning js = new Clonning(cs);
        Clonning js = (Clonning) cs.clone();
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
