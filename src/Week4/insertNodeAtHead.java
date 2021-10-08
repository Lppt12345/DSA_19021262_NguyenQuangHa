package Week4;

public class insertNodeAtHead {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode p = new SinglyLinkedListNode(data);
        SinglyLinkedListNode first = llist;
        if (llist == null){
            llist = p;
            return llist;
        }
        else{
            p.next = first;
            llist = p;
            return  llist;
        }
        // node.next = llist;
        // return node;
    }
}
