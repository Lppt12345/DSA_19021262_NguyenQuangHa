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

    //    public static void printAll(int[] a) {
//        int n = a.length;
//        Arrays.sort(a);
//        int l, r;
//        for (int i = 0; i < n - 2; i++) {
//            l = i + 1;
//            r = n - 1;
//            while (l < r) {
//                if (a[i] + a[l] + a[r] == 0) {
//                    System.out.println(a[i] + " and " + a[l] + " and " + a[r]);
//                    l++;
//                    r--;
//                } else if (a[i] + a[l] + a[r] < 0) {
//                    l++;
//                } else {
//                    r--;
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        In in = new In("D:\\CTDL\\lib\\algs4-data\\1Kints.txt");
        int[] b = in.readAllInts();
        printAll(b);
        System.out.println();
        int[] a = {2,-2,0,1,-3,-4,5,7,-1};
        printAll(a);
    }



}
