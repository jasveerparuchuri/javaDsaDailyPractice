package com.jasveer.Heaps;

public class HeapSort {

    // Function to heapify subtree rooted at index i
    static void heapify(int[] arr, int n, int i) {
        int largest = i;        // Assume current i is largest
        int left = 2 * i + 1;   // Left child
        int right = 2 * i + 2;  // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to perform heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap (from bottom up)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility function to print array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array using Heap Sort:");
        printArray(arr);
    }
}
