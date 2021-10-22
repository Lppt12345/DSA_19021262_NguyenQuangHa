package Week6.Sort;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GenerateArray {
    private static final int SIZE = 20000;
    // Doc tu file
    public static Integer[] inputFromFile(String path) {
        In in = new In(path);
        int[] array = in.readAllInts();
        Integer[] a = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        return a;
    }

    public static Integer[] randomIntegerArr() {
        int[] a = new Random().ints(-999999, 999999).limit(SIZE).toArray();
        Integer[] arr = new Integer[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
//        Integer[] arr = new Integer[SIZE];
//        Random generator = new Random();
//        for (int i = 0; i < SIZE; i++) {
//            arr[i] = generator.nextInt();
//        }
        return arr;
    }
    // Sap xep mang
    public static Integer[] sortedIntegerArr() {
        Integer[] arr = randomIntegerArr();
        Arrays.sort(arr);
        return arr;
    }
    // Sap xep nguoc
    public static Integer[] reverseSortedIntegerArray() {
        Integer[] arr = randomIntegerArr();
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }
    // Mang du lieu bang nhau
    public static Integer[] equalIntegerArray(int n) {
        Integer[] arr = new Integer[SIZE];
        Arrays.fill(arr, n);
        return arr;
    }
    // Float nagy nhien

    public static Float[] randomFloatArr() {
        Float[] arr = new Float[SIZE];
        Random generator = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = generator.nextFloat();
        }
        return arr;
    }
    public static Float[] sortedFloatArray() {
        Float[] arr = randomFloatArr();
        Arrays.sort(arr);
        return arr;
    }

    public static Float[] reverseSortedFloatArray() {
        Float[] arr = randomFloatArr();
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }
    // Mang float bang nhau
    public static Float[] equalFloatArray(float value) {
        Float[] arr = new Float[SIZE];
        Arrays.fill(arr, value);
        return arr;
    }

}
