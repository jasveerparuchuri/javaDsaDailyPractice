package com.jasveer.OOPS.Comparing;

public class Student implements Comparable<Student> {
    int rollno;
    float marks;
    public Student(int rollno, float marks){
        this.marks = marks;
        this.rollno = rollno;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);
        return diff;
    }
}
