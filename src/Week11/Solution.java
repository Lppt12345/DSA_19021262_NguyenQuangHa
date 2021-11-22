package Week11;

import Week4.ReversePrint;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Node {
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static void reversePrint(Node head, int k) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        int count = k;
        while (cur != null && count>=0){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count--;
        }
        head = pre;

        Node tmp = head;
        while (k>0 && tmp!= null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
            k--;
            if (tmp == null){
                break;
            }
        }

    }
}
