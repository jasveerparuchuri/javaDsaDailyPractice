package com.jasveer.LinkedList;

public class QuestionLL {
    private Node head;
    private Node tail;
    private int size;

    public QuestionLL() {
        this.size = 0;
    }

    public void insertLast(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }


    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.value < list2.value) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static void main(String[] args) {
        QuestionLL list1 = new QuestionLL();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);

        QuestionLL list2 = new QuestionLL();
        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(6);

        QuestionLL.Node merged = QuestionLL.mergeTwoLists(list1.getHead(), list2.getHead());
        QuestionLL.display(merged);
    }
}
