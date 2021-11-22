//package Coursera.DequesAndRandomizedQueues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int nItem = 0;
    private Node first ;
    // construct an empty randomized queue
    public RandomizedQueue(){
        this.first = null;
        this.nItem = 0;
    }
    private class Node{
        Item item;
        Node next;
        Node (Item data){
            this.item = data;
            next = null;
        }
    }

    private boolean isValidItem(Item item){
        if (item == null){
            return  false;
        }
        return true;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return nItem == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return nItem;
    }

    // add the item
    public void enqueue(Item item){
        if (!isValidItem(item)){
            throw new NullPointerException("Item add vao bi null");
        }
        // Them no vao dau
        if (first == null || isEmpty()){
            first = new Node(item);
        }
        else {
            Node tmp = first;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node(item);
        }
        nItem ++ ;
    }

    // remove and return a random item
    public Item dequeue(){
        if (isEmpty()){
            throw  new  NoSuchElementException("Loi khong thay phan tu nao");
        }
        int random = StdRandom.uniform(nItem);
        Item tmp;
        if (random == 0){
            tmp = first.item;
            first = first.next;
        }else {
            Node check = first;
            while (random > 1){
                check = check.next;
                random -- ;
            }
            tmp = check.next.item;
            check.next = check.next.next;
        }
        nItem --;
        return  tmp;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (isEmpty()){
            throw  new  NoSuchElementException("Loi khong thay phan tu nao");
        }
        int random = StdRandom.uniform(nItem);
        Item tmp;
        if (random == 0){
            tmp = first.item;
            first = first.next;
        }else {
            Node check = first;
            while (random > 1){
                check = check.next;
                random -- ;
            }
            tmp = check.next.item;
        }
        nItem --;
        return  tmp;
    }

    // return an independent iterator over items in random order
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
            Item item =  cur.item;
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
        RandomizedQueue<Integer> test = new RandomizedQueue<Integer>();
        test.enqueue(13);
        test.enqueue(14);
        test.enqueue(15);
        test.enqueue(16);
        test.enqueue(17);
        test.enqueue(18);
        test.enqueue(19);
        test.enqueue(20);
        for (Integer s : test) {
            System.out.println(s);
        }
        System.out.println( "So ngau nhien la: " + test.sample());
    }

}