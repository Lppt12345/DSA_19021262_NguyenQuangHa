package Week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSum {
    public static void printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) System.out.println(a[i] + "and" + a[j] + "and" + a[k]);
            }
        }
    }
    public static void main(String[] args) {
        In in = new In("D:\\CTDL\\lib\\algs4-data\\1Kints.txt");
        int[] b = in.readAllInts();
        printAll(b);
        System.out.println();
        int[] a = {2,-2,0,1,-3,-4,5,7,-1};
        printAll(a);
    }
}
