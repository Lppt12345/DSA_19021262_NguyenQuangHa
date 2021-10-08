package Week4;

public class InsertNodeAtPosition {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        if (position == 0) {
            node.next = llist;
            return node;
        }
        else{
            SinglyLinkedListNode p =llist;
            while (position != 1){
                p = p.next;
                position --;
            }
            node.next = p.next;
            p.next = node;
            return  llist;
        }
    }
    //
////    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
//
//        if (position == 0) {
//        node.next = head;
//        head = node;
//    } else {
//        SinglyLinkedListNode p = head;
//        while (--position != 0) {
//            p = p.next;
//        }
//        node.next = p.next;
//        p.next = node;
//    }
//        return head;
}
