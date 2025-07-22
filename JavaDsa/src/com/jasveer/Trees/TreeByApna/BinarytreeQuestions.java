package com.jasveer.Trees.TreeByApna;


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
}
