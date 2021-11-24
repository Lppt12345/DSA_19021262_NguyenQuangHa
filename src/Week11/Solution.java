//package Week11;
//
//import Week4.ReversePrint;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Solution {
//    static class Node {
//        public int data;
//        public Node next;
//
//        public Node(int nodeData) {
//            this.data = nodeData;
//            this.next = null;
//        }
//    }
//
//    public static void reversePrint(Node head, int k) {
//        Node cur = head;
//        Node pre = null;
//        Node next = null;
//        int count = k;
//        while (cur != null && count>=0){
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//            count--;
//        }
//        head = pre;
//
//        Node tmp = head;
//        while (k>0 && tmp!= null){
//            System.out.print(tmp.data + " ");
//            tmp = tmp.next;
//            k--;
//            if (tmp == null){
//                break;
//            }
//        }
//
//    }
//}
// class b {
//    public static String isBalanced(String s) {
//        Stack<Character> S = new Stack<>();
//        for (int i =0; i< s.length() ; i++ ){
//            char c = s.charAt(i);
//            switch (c){
//                case '{':
//                case '[':
//                case  '(':
//                    S.push(c);
//                    break;
//                case ']':
//                    if (S.isEmpty() || S.pop() == '{'){
//                        return "INVALID";
//                    }
//                    break;
//                case ')':
//                    if (S.isEmpty() || S.pop() != '('){
//                        return "INVALID";
//                    }
//                    break;
//                case '}':
//                    if (S.isEmpty() || S.pop() != '{'){
//                        return "INVALID";
//                    }
//                    break;
//            }
//        }
//        return (S.isEmpty()) ?  "VALID" : "INVALID";
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = new String();
//        s = sc.next();
//        System.out.println(isBalanced(s));
//    }
//}
//public class a {
//    public static void selectionSort(int[] arr, int n){
//        int i, j, min;
//        for (i = 1; i < n - 2; i++){
//            min = i;
//            for (j = i+1; j< n - 1;j++){
//                if (arr[j] < arr[min]){
//                    min = j;
//                }
//            }
//            if (min != i){
//                int tmp = arr[min];
//                arr[min] = arr[i];
//                arr[i] = tmp;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n;
//        n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        selectionSort (arr, n);
//
//        for (int i = 0;i<n;i++){
//            System.out.print(arr[i] + " ");
//        }
//
//    }
//}
