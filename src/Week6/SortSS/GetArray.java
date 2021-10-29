package Week6.SortSS;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GetArray {
    private static final int SIZE = 20000;

    // Doc tu file
    public static int[] inputFromFile(String path) {
        In in = new In(path);
        int[] a = in.readAllInts();
        return a;
    }

    public static int[] randomIntegerArr() {
        //        Integer[] arr = new Integer[SIZE];
//        Random generator = new Random();
//        for (int i = 0; i < SIZE; i++) {
//            arr[i] = generator.nextInt();
//        }
        return new Random().ints(-9999, 9999).limit(SIZE).toArray();
    }

    // Sap xep mang
    public static int[] sortedIntegerArr() {
        int[] arr = randomIntegerArr();
        Arrays.sort(arr);
        return arr;
    }

    // Sap xep nguoc
    public static int[] reverseSortedIntegerArray() {
        int[] array = randomIntegerArr();
        Arrays.sort(array);
        int[] descArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            descArray[i] = array[(array.length - 1) - i];
        }
        return descArray;
    }

    // Mang du lieu bang nhau
    public static int[] equalIntegerArray(int n) {
        int[] arr = new int[SIZE];
        Arrays.fill(arr, n);
        return arr;
    }
}
