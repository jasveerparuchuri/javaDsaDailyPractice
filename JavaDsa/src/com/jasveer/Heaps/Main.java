package com.jasveer.Heaps;

public class Main {
    public static void main(String[] args) {
        MinHeap pq = new MinHeap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}
