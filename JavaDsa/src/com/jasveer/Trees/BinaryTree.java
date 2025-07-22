package com.jasveer.Trees;

import java.util.Scanner;

public class BinaryTree {

    private static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

    }
    private Node root;

    public void populate(Scanner sc){
        System.out.println("Enter a root node");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc,root);
    }

    private void populate(Scanner sc,Node node){
        // left Node
        System.out.println("Do you want to enter a left value of root node ? True OR False :"+ node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value for left node to be inserted : "+node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc,node.left);
        }
        // right Node
        System.out.println("Do you want to enter a right value of root node ? True OR False: "+ node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value for right node to be inserted : "+node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        prettyDisplay(root,0);
    }

    private void display(Node node, String indent) {
        if(node == null){
            return;
        }
        System.out.println(indent+node.value);
        display(node.left,"\t");
        display(node.right,"\t");
    }


    private void prettyDisplay(Node node , int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right ,level+1);
        if(level != 0){
            for(int i = 0 ;i< level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }

}
