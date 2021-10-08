package Week4;

public class deleteNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        if (position == 0){
            llist = llist.next;
        }
        else{
            SinglyLinkedListNode p = llist;
            while (position != 1){     // while (-- position)
                p = p.next;
                position -- ;
            }
            p.next = p.next.next;
        }
        return  llist;
    }
}
