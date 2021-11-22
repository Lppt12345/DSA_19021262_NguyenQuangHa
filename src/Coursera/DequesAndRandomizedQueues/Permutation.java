//package Coursera.DequesAndRandomizedQueues;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        RandomizedQueue<String> test = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            test.enqueue(StdIn.readString());
        }
        for (int i = 0; i < x; i++) {
            System.out.println(test.dequeue());
        }
    }
}