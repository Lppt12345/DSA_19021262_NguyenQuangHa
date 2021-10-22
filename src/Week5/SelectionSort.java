package Week5;

import edu.princeton.cs.algs4.In;

public class SelectionSort {
    public static void main(String[] args) {
        In in = new In("lib/algs4-data/16Kints.txt");
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        long end = System.currentTimeMillis();
        System.out.println((double)(end - start)/1000);
    }
}