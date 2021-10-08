package Week4;

public class MergeLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        // tim node nho nhat roi gan do la head de tiep tuc tim node tiep theo
        if (head1.data < head2.data){
            head1.next = mergeLists(head1.next , head2);
            return head1;
        }
        else{
            head2.next = mergeLists(head1 , head2.next);
            return head2;
        }
   }

    // Tham khao
//        Node MergeLists(Node currA, Node currB) {
//            if (currA == null) {
//                return currB;
//            } else if (currB == null) {
//                return currA;
//            }
//
//            /* Find new head pointer */
//            Node head = null;
//            if (currA.data < currB.data) {
//                head = currA;
//                currA = currA.next;
//            } else {
//                head = currB;
//                currB = currB.next;
//            }
//
//            /* Build rest of list */
//            Node n = head;
//            while (currA != null && currB != null) {
//                if (currA.data < currB.data) {
//                    n.next = currA;
//                    currA = currA.next;
//                } else {
//                    n.next = currB;
//                    currB = currB.next;
//                }
//                n = n.next;
//            }
//
//            /* Attach the remaining elements */
//            if (currA == null) {
//                n.next = currB;
//            } else {
//                n.next = currA;
//            }
//
//            return head;
}
