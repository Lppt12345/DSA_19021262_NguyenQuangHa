package Week6.Sort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;

import java.util.Arrays;

public class Sort {
    public static long insertionSortTime(Comparable[] a) {
        long start = System.currentTimeMillis();
//        Insertion.sort(a); dung thu vien
        InsertionSort.sort(a);
        return System.currentTimeMillis() - start;
    }
    static long mergeSort(Comparable[] a) {
        long start = System.currentTimeMillis();
//        Merge.sort(a);

        return System.currentTimeMillis() - start;
    }

    static long quickSort(Comparable[] a) {
        long start = System.currentTimeMillis();
        Quick.sort(a);
        return System.currentTimeMillis() - start;
    }

    public static void insertTest(int number, Integer [] arr){
        System.out.println("Insertion sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            time = insertionSortTime(Arrays.copyOf(arr,arr.length));
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }
        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }

    public static void quickTest(int number, Integer [] arr){
        System.out.println("Quick sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            time = quickSort(Arrays.copyOf(arr,arr.length));
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }
        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }

    public static void mergeTest(int number, Integer [] arr){
        System.out.println("Merge sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            time = mergeSort(Arrays.copyOf(arr,arr.length));
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }
        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }
//    public static void insertTest(int number, Integer [] arr){
//        System.out.println("Insertion sort: ");
//        Integer [] test = arr;
//        long time = 0;
//        time = insertionSortTime(test);
//        System.out.println("Lan " + number + " : " + time);
//    }
//
//    public static void quickTest(int number, Integer [] arr){
//        System.out.println("Quick sort: ");
//        Integer [] test = arr;
//        long time = 0;
//        time = quickSort(test);
//        System.out.println("Lan " + number + " : " + time);
//    }
//
//    public static void mergeTest(int number, Integer [] arr){
//        System.out.println("Merge sort: ");
//        Integer [] test = arr;
//        long time = 0;
//        time = mergeSort(test);
//        System.out.println("Lan " + number + " : " + time);
//    }
    // test random
    public static  void testRandom(int number){
        System.out.println("TEST RANDOM:");
        Integer [] arr = GenerateArray.randomIntegerArr();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test reverse
    public static  void testReverse(int number){
        System.out.println("TEST REVERSE:");
        Integer [] arr = GenerateArray.reverseSortedIntegerArray();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test sorted
    public static void testSorted(int number){
        Integer [] arr = GenerateArray.sortedIntegerArr();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test equal
    public static  void testEqual(int n , int number){
        System.out.println("TEST EQUAL:");
        Integer [] arr = GenerateArray.equalIntegerArray(n);
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }


    public static void testTXT(String path , int number){
        System.out.println("TEST INPUT FROM FILE:" + path);
        Integer [] arr = GenerateArray.inputFromFile(path);
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }

}
