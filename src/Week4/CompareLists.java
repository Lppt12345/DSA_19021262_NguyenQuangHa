package Week4;

public class CompareLists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode check1 = head1;
        SinglyLinkedListNode check2 = head2;
        while (check1 != null && check2 != null){
            if (check1.data != check2.data) {
                return false;
            }
            check1 = check1.next;
            check2 = check2.next;
        }
        if (check1 != null || check2 != null){
            return false;
        }
        else return true;

//        SinglyLinkedListNode p1 = head1, p2 = head2;
//        while (p1 != null || p2 != null) {
//            if (p1 == null || p2 == null || p1.data != p2.data) {
//                return false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//
//        return true;
    }
}
