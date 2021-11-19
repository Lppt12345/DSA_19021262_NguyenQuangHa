package Week10;

import java.util.Scanner;

public class LowestCommonAncestor {
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

    public static Node lca (Node root, int data1, int data2){
        if (root.data > data1 && root.data > data2){
            return lca (root.left, data1 , data2);
        }
        if (root.data < data1 && root.data < data2){
            return lca (root.right, data1 , data2);
        }
        return root;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for (int i = 0; i< n ; i++){
            int data = sc.nextInt();
            root = insert (root, data);
        }
        int v1  = sc.nextInt();
        int v2  = sc.nextInt();
        Node a = lca(root, v1, v2);
        System.out.println(a.data);
    }
}
