package Week4;

public class printLinkedList {
    // Complete the printLinkedList function below.

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode p = head;
        while (p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }

}
