package Week10;

import java.util.Scanner;

public class HeightBinaryTree {
    static class Node {
        Node left;
        Node right;
        int data;
        Node (int data){
            left = null;
            right = null;
            this.data = data;
        }
    }

    public static Node insert (Node node , int data){
        if (node == null) {
            return new Node (data);
        }
        Node newNode;
        if (data > node.data){
            newNode = insert(node.right, data);
            node.right = newNode;
        }else {
            newNode = insert(node.left, data);
            node.left = newNode;
        }
        return node;
    }

    public static int height(Node root){
        int leftH = 0;
        int rightH = 0;
        if (root.left == null && root.right == null) return 0;
        if (root.left != null){
            leftH = 1 + height(root.left);
        }
        if (root.right != null){
            rightH = 1 + height(root.right);
        }
        return rightH > leftH ? rightH : leftH;
    }


    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i< n ; i++){
            int data = sc.nextInt();
            root = insert (root, data);
        }
        int height  = height(root);
        System.out.println(height);
    }
}
