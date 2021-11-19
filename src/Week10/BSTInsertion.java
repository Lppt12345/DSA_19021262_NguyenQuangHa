package Week10;

import Week9.PreorderTraversal;

import java.util.Scanner;

public class BSTInsertion {
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
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node insert (Node node , int data){
        if (node == null) {
            return new Node(data);
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
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i< n ; i++){
            int data = sc.nextInt();
            root = insert (root, data);
        }
        preOrder(root);
    }
}
