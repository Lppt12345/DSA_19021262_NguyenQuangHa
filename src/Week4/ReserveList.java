package Week4;

public class ReserveList {
    static class SinglyLinkedListNode {
        public int data;
        public reversePrint.SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode node = llist;
        SinglyLinkedListNode tail = null , next;
        while (node != null){
            next = node.next;  // gan con tro next vao node tiep theo
            node.next = tail;    // gan dia chir con tro o o tiep theo vao bien pre
            tail = node;        // cho pre bang node tuc la da dao chieu con tro
            node = next ;       // cho node bang next
        }
        return tail;


////        Node Reverse(Node head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//
//            Node newHead = Reverse(head.next); // reverse all but first
//            head.next.next = head; // make original second point at first
//            head.next = null; // make original first point at nothing
//
//            return newHead;
//        }
    }

}
