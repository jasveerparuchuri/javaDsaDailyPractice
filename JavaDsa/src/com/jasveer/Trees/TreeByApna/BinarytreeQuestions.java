package com.jasveer.Trees.TreeByApna;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static com.jasveer.Trees.TreeByApna.BinaryTree.height;


public class BinarytreeQuestions {
    // count nodes
    public static int countNodes(BinaryTree.Node root){
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }

    //sum of nodes
    public static int sumNodes(BinaryTree.Node root, int sum){
        if(root == null){
            return sum;
        }

        int left = sumNodes(root.left,sum );
        int right = sumNodes(root.right,sum);

        return root.val+left+right;
    }

    //Max Diameterof tree
    public static int diameter(BinaryTree.Node node){
        if(node == null){
            return 0;
        }
        int leftDia = diameter(node.left);
        int rightDia = diameter(node.right);
        int leftHei = height(node.left);
        int rightHei = height(node.right);

        int selfDia = leftHei+rightHei+1;
        return Math.max(selfDia,Math.max(leftDia,rightDia));
    }

    // diameter approach 2
    static class Info{
        int dia;
        int ht;
        Info(int dia,int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter2(BinaryTree.Node node){
        if(node ==null){
            return new Info(0,0);
        }
        Info leftDia = diameter2(node.left);
        Info rightDia = diameter2(node.right);
        int selfDia =(leftDia.ht + rightDia.ht)+1;
        int finalDia = Math.max(leftDia.dia,Math.max(rightDia.dia,selfDia));
        int ht = Math.max(leftDia.ht, rightDia.ht)+1;
        return new Info(finalDia,ht);

    }


    // subtree check in main tree
    public static boolean subTree(BinaryTree.Node tree ,BinaryTree.Node subtree){
        if(tree == null){
            return false;
        }
        if(tree.val == subtree.val){
            if(isIdentical(tree,subtree)){
                return true;
            }
        }
        return subTree(tree.left,subtree) || subTree(tree.right,subtree);
    }
    public static boolean isIdentical(BinaryTree.Node tree,BinaryTree.Node subtree){
        if(tree == null && subtree == null){
            return true;
        }else if((tree == null) || (subtree == null) || tree.val != subtree.val ){
            return false;
        }
        if(!isIdentical(tree.left ,subtree.left)){
            return false;
        }
        if(!isIdentical(tree.right ,subtree.right)){
            return false;
        }
        return true;
    }

      static class Info1{
        BinaryTree.Node node;
        int hd;
        Info1(BinaryTree.Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
     }

    // top view of tree
    public static  void topView(BinaryTree.Node root){
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, BinaryTree.Node> map = new HashMap<>();
        int min= 0,max = 0;
        q.add(new Info1(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info1 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left != null ){
                    q.add(new Info1(curr.node.left, curr.hd-1));
                    min  = Math.min(min,curr.hd-1);
                }if(curr.node.right != null ){
                    q.add(new Info1(curr.node.right, curr.hd+1));
                    max  = Math.max(min,curr.hd+1);
                }
            }
        }
        for(int i= min;i<=max;i++){
            System.out.println(map.get(i).val);
        }
    }

    public static void kthLevelI(BinaryTree.Node node,int k,int level){
        if(node == null){
            return;
        }
        if(level == k){
            System.out.print(node.val+" ");
            return;
        }
        kthLevelI(node.left,k,level+1);
        kthLevelI(node.right,k,level+1);
    }

    // lowest coomon ancesstor approach1
    public static BinaryTree.Node lca1(BinaryTree.Node root ,int n1,int n2){
        ArrayList<BinaryTree.Node> p1 = new ArrayList<>();
        ArrayList<BinaryTree.Node> p2 = new ArrayList<>();
        getPath(root,n1,p1);
        getPath(root,n2,p2);

        int i = 0;
        for(;i<p1.size() && i< p2.size();i++){
            if(p1.get(i) != p2.get(i)){
                break;
            }
        }
        return p1.get(i-1);
    }
    public static boolean getPath(BinaryTree.Node node,int n,ArrayList<BinaryTree.Node> p){
        if(node == null){
            return false;
        }
        p.add(node);

        if(node.val == n ){
            return true;
        }
         boolean left = getPath(node.left,n,p);
         boolean right = getPath(node.right,n,p);
         if( left || right){
             return true;
         }
         p.remove(p.size()-1);
         return false;

    }
    public static BinaryTree.Node lca2(BinaryTree.Node root,int n1,int n2){
        if(root == null || (root.val == n1) || (root.val == n2)){
            return root;
        }
        BinaryTree.Node left = lca2(root.left,n1,n2);
        BinaryTree.Node right = lca2(root.right,n1,n2);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
