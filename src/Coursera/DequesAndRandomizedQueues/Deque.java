//package Coursera.DequesAndRandomizedQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int nItem = 0;
    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node prev;
        Node next;
    }

    // construct an empty deque
    public Deque(){
        this.first = null;
        this.last =  null;
        nItem = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return nItem == 0;
    }

    // return the number of items on the deque
    public int size(){
        return nItem;
    }
    // Kiem tra Item
    private boolean isValidItem(Item item){
        if (item == null){
            return  false;
        }
        return true;
    }

    // add the item to the front
    public void addFirst(Item item){
        // In ra neu ko co item hop le
        if (!isValidItem(item)){
            throw new NullPointerException("Item add vao bi null");
        }
        // Tao clone cua first roi cho frist la 1 Node moi
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        first.prev = null;
        // Check xem queue co rong hay ko
        if (last == null || isEmpty()) {
            last = first;
        } else {
            old.prev = first;
        }
        nItem++;
    }

    // add the item to the back
    public void addLast(Item item){
        // Check dau vao
        if (!isValidItem(item)){
            throw new NullPointerException("Item add vao bi null");
        }
        // Tao clone cua last roi cho last gia tri moi
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = old;
        // Check dieu kien rong
        if (first == null || isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
        nItem++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (isEmpty() || first == null){
            throw new NoSuchElementException("Loi khong thay phan tu nao");
        }
        Item tmp = first.item;
        // Gan first cho 1 phia sau no
        first = first.next;
        // Xoa bo phan tu dau
        if (nItem - 1 == 0){
            last = null;
            first = null;
        }else {
            first.prev = null;
        }
        nItem --;
        return tmp;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (isEmpty() || first == null){
            throw new NoSuchElementException("Loi khong thay phan tu nao");
        }
        Item tmp = last.item;
        // Cho no len 1 buoc
        last = last.prev;
        // Xoa bo phan tu dau
        if (nItem - 1 == 0){
            first = null;
            last = null;
        }else {
            last.next = null;
        }
        nItem --;
        return tmp;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ItemIterator();
    }
    private class ItemIterator implements Iterator<Item> {
        private Node cur = first;
        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {
            throw  new UnsupportedOperationException();
        }
    }


    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> test = new Deque<Integer>();
        System.out.println(test.isEmpty());
        test.addLast(10);
        test.addFirst(11);
        test.addFirst(13);
        test.addFirst(14);
        test.addFirst(21);
        test.addFirst(33);
        test.addFirst(64);
        test.addFirst(21);
        test.addFirst(53);
        test.addFirst(664);
        test.addLast(55);
        test.removeFirst();
        test.removeLast();
        for (Integer n : test) {
            System.out.println(n);
        }
    }

}