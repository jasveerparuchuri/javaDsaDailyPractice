package com.jasveer.LinkedList;

public  class LL{

    private Node head;
    private Node tail;


    private int size;
    public LL(){
        this.size = 0;
    }
    public  void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public  void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertIndex(int value, int index){
        if(index ==0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }

        Node temp = head;
        for(int i = 1;i<index;i++){
            temp = temp.next;
        }

        Node  node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public  int deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }

    public int deleteIndex(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node previous = get(index-1);
        int value = previous.next.value;
        previous.next = previous.next.next;
        return value;
    }

     public Node findNode(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
     }
     public Node get(int index){
        Node node = head;
        for(int i = 0; i < index;i++){
            node = node.next;
        }
        return node;
     }
    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val,int index,Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

        node.next = insertRec(val,index-1,node.next);
        return node;
    }




    private class Node {
        private int value;
        private Node next;


        public  Node(int value){
            this.value = value;
        }

        public  Node(int value,Node next){
            this.value = value;
            this.next = next;
        }



    }
}


