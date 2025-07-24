package com.jasveer.Trees.TreeByApna;

import java.util.ArrayList;

public class Bst {
    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }



    public  static Node insertNodes(Node root, int val) {
        if(root == null){
            return new Node(val);
        }

        if(root.val > val){
            root.left = insertNodes(root.left, val);
        }else{
            root.right = insertNodes(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    static class Ques{
        public static  boolean searchBst(Node root,int k){
            if(root == null){
                return false;
            }
            if(root.val == k){
                return true;
            }else if(root.val > k){
                return  searchBst(root.left,k);
            }else{
                return searchBst(root.right,k);
            }

        }
        // deleteing node
        public static Node deleteNode(Node root,int val){
            if(root == null){
                return  null;
            }
            if(root.val > val){
                root.left = deleteNode(root.left,val);
            } else if (root.val < val) {
                root.right = deleteNode(root.right,val);
            }else{
                // case1
                if(root.left == null && root.right == null){
                    return null;
                }
                // case 2
                if(root.right == null){
                    return root.left;
                }
                else if(root.left == null){
                    return root.right;
                }

                // case 3
                Node is = findInSuccessor(root.right);
                root.val = is.val;
                return root.right = deleteNode(root.right,val);

            }
            return root;
        }
        public static Node findInSuccessor(Node node){
            if(node.left == null){
                return node;
            }
            return findInSuccessor(node.left);
        }
        //print in range
        public static void printInRange(Node root, int f,int l){
            if(root == null){
                return;
            }
            if((root.val >= f) && root.val <= l){
                printInRange(root.left,f,l);
                System.out.print(root.val+" ");
                printInRange(root.right,f,l);

            }else if (root.val < f){
                printInRange(root.left,f,l);
            }else{
                printInRange(root.right,f,l);
            }
        }
        public static void printRootToLeaf(Node root, ArrayList<Integer> arr){
            if(root == null){
                return;
            }
            arr.add(root.val);
            if(root.left == null && root.right == null){
                System.out.println(arr.toString());
//                printPath(arr);
            }
            printRootToLeaf(root.left,arr);
            printRootToLeaf(root.right,arr);
            arr.remove(arr.size()-1);
        }
//        public static void printPath(ArrayList<Integer> arr){
//            sout
//        }
    }

    public static void main(String[] args) {
        int[] nodes = {5,1,3,4,2,7};
        Node root = null;
        for (int i = 0; i <nodes.length ; i++) {
            root = insertNodes(root, nodes[i]);

        }
//        inorder(root);

//        System.out.println(Ques.searchBst(root,0));
//        root = Ques.deleteNode(root, 3);
//
//        inorder(root);
//        System.out.println();
//        Ques.printInRange(root,1,5);
        Ques.printRootToLeaf(root,new ArrayList<>());

    }



}
