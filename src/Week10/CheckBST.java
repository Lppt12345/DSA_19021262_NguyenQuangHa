package Week10;

import java.util.Scanner;

public class CheckBST {
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
    static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max)
            return false;

        if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max))
            return false;

        return true;
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
        System.out.println();
        System.out.println(checkBST(root));
    }
}
