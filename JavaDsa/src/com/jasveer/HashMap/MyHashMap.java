package com.jasveer.HashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

class HashNode<K, V> {
    K key;
    V value;
    final int hashCode;
    HashNode<K, V> next;

    HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

public class MyHashMap<K, V> {
    private ArrayList<LinkedList<HashNode<K, V>>> bucketArray;
    private int numBuckets;
    private int size;

    public MyHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(new LinkedList<>());
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Objects.hashCode(key);
        int index = hashCode % numBuckets;
        return index < 0 ? -index : index;
    }

    public int size() {
        // Uses LinkedList.size() built-in method for each bucket
        int total = 0;
        for (LinkedList<HashNode<K, V>> bucket : bucketArray) {
            total += bucket.size();
        }
        return total;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = bucketArray.get(bucketIndex);

        for (HashNode<K, V> node : bucket) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = bucketArray.get(bucketIndex);

        for (HashNode<K, V> node : bucket) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new HashNode<>(key, value, key.hashCode()));
        size++;

        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor >= 0.7) {
            rehash();
        }
    }

    private void rehash() {
        ArrayList<LinkedList<HashNode<K, V>>> oldBuckets = bucketArray;
        numBuckets *= 2;
        bucketArray = new ArrayList<>();
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(new LinkedList<>());
        }

        for (LinkedList<HashNode<K, V>> bucket : oldBuckets) {
            for (HashNode<K, V> node : bucket) {
                add(node.key, node.value);
            }
        }
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> bucket = bucketArray.get(bucketIndex);

        HashNode<K, V> toRemove = null;
        for (HashNode<K, V> node : bucket) {
            if (Objects.equals(node.key, key)) {
                toRemove = node;
                break;
            }
        }

        if (toRemove == null) return null;

        bucket.remove(toRemove);
        size--;
        return toRemove.value;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("this", 4);
        map.add("hi", 5);

        System.out.println("Size: " + map.size());         // Expected: 3
        System.out.println("this: " + map.get("this"));   // Expected: 4
        System.out.println("Removed this: " + map.remove("this")); // Expected: 4
        System.out.println("Size now: " + map.size());    // Expected: 2
        System.out.println("Is empty? " + map.isEmpty()); // Expected: false
    }
}
