package Week4;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class GetNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        List<Integer> arr = new ArrayList<Integer>();
        SinglyLinkedListNode p = llist;
        while (p != null){
            arr.add(p.data);
            p = p.next;
        }
        return (arr.get(arr.size() - 1 -positionFromTail));
    }
//    SinglyLinkedListNode node = head, result = head;
//        while (positionFromTail-- != 0) {
//        node = node.next;
//    }
//
//        while (node.next != null) {
//        node = node.next;
//        result = result.next;
//    }
//
//        return result.data;
}
