package Week9;

import java.util.Scanner;

public class SortedLinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head = null;

    void insertDescending(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else if (head.value <= newNode.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node p = head;
            while (p != null) {
                if (p.next == null) {
                    p.next = newNode;
                    break;
                } else if (p.next.value <= newNode.value) {
                    newNode.next = p.next;
                    p.next = newNode;
                    break;
                }
                p = p.next;
            }
        }
    }

    void insertAscending(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else if (head.value >= newNode.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node p = head;
            while (p != null) {
                if (p.next == null) {
                    p.next = newNode;
                    break;
                } else if (p.next.value >= newNode.value) {
                    newNode.next = p.next;
                    p.next = newNode;
                    break;
                }
                p = p.next;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        Node p = head;
        while (p != null) {
            s += Integer.toString(p.value) + " ";
            p = p.next;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        SortedLinkedList llist = new SortedLinkedList();
        for (int i = 0; i < n; i++) {
            llist.insertDescending(scan.nextInt());
        }
        scan.close();
        System.out.println(llist);
    }
}