package Week4;

import java.util.ArrayList;
import java.util.List;

public class reversePrint {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static void reversePrint(SinglyLinkedListNode llist) {
        List <Integer> arr = new ArrayList<Integer>();

        if (llist != null){
            SinglyLinkedListNode p = llist;
            while (p != null){
                arr.add(p.data);
                p = p.next;
            }
            for (int i = arr.size() -1 ; i >=0 ; i--){
                System.out.println(arr.get(i));
            }
        }
    }
//    static void reversePrint(SinglyLinkedListNode head) {
//        if (head.next != null) {
//            reversePrint(head.next);
//        }
//        System.out.println(head.data);
//    }
}
