package com.jasveer.Heaps;

import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public void add(int data) {
        heap.add(data);

        int childIdx = heap.size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        // Up-Heapify
        while (childIdx > 0 && heap.get(childIdx) < heap.get(parentIdx)) {
            // Swap
            int temp = heap.get(childIdx);
            heap.set(childIdx, heap.get(parentIdx));
            heap.set(parentIdx, temp);

            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        int data = heap.get(0);

        // Step 1: Swap first and last
        int lastIdx = heap.size() - 1;
        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);

        // Step 2: Down-Heapify
        heapify(0);

        return data;
    }

    private void heapify(int idx) {
        int smallest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != idx) {
            // Swap
            int temp = heap.get(idx);
            heap.set(idx, heap.get(smallest));
            heap.set(smallest, temp);

            heapify(smallest);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}


