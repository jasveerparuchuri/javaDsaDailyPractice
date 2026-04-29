package com.jasveer.Trees;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCreation {


     private int idx = -1;
    public Node buildTree(int[] nodes){
        idx = -1;
        return createBinaryTree(nodes);
    }
    private Node createBinaryTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        Node node = new Node(nodes[idx]);
        node.left = createBinaryTree(nodes);
        node.right = createBinaryTree(nodes);
        return node;
    }
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node current  = q.poll();
            if(current == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else {
                    q.offer(null);
                }
            }
            else
            {
                System.out.print(current.val+" ");
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeCreation binaryTreeCreation = new BinaryTreeCreation();
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = binaryTreeCreation.buildTree(nodes);
//            binaryTreeCreation.preOrder(root);
            binaryTreeCreation.levelOrder(root);

    }
}
