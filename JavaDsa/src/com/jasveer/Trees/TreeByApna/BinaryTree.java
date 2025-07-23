package com.jasveer.Trees.TreeByApna;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {



    static class BinaryTree1{
        int idx = -1;
        public Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node node = new Node(nodes[idx]);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }

    }

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static  void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public static  void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node current = q.remove();
            if(current == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else{
                System.out.print(current.val+" ");
                if(current.left != null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);
            }
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }

    // questions


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int subNodes[] = {2,4,-1,-1,5,-1,-1};
        BinaryTree1 tree = new BinaryTree1();
        Node subRoot = tree.buildTree(subNodes);
        tree.idx = -1;
        Node root = tree.buildTree(nodes);


//        System.out.println(root.val);
        BinarytreeQuestions q  = new BinarytreeQuestions();
////        preOrder(root);
////        System.out.println();
////        inOrder(root);
////        System.out.println();
////        postOrder(root);
////        System.out.println();
//        levelOrder(root);
////        System.out.println(q.sumNodes(root,0));
//        System.out.println(q.diameter(root));
//        System.out.println(q.diameter2(root).dia);
//        System.out.println(q.subTree(root,subRoot));
//            q.topView(root);
//        q.kthLevelI(root,3,1);
        System.out.println(q.lca2(root,4,3).val);
    }
}
