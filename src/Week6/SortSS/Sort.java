package Week6.SortSS;

import Week6.Sort.GenerateArray;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;

import java.util.Arrays;

public class Sort {
    public static long insertionSortTime(int [] a) {
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
//        Insertion.sort(a);
        InsertionSort.insertionSort(a);
        end = System.currentTimeMillis();
        return end - start;
    }
    static long mergeSort(int [] a) {
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
//        Merge.sort(a);
        MergeSort.mergeSort(a, a.length);
        end = System.currentTimeMillis();
        return end - start;
    }

    static long quickSort(int [] a) {
        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
//        Quick.sort(a);
        QuickSort.quickSort(a, 0 , a.length - 1);
        end = System.currentTimeMillis();
        return end - start;
    }

    public static void insertTest(int number, int [] arr){
        System.out.println("Insertion sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            int [] test = Arrays.copyOf(arr,arr.length);
            time = insertionSortTime(test);
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }

        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }

    public static void quickTest(int number, int [] arr){
        System.out.println("Quick sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            int [] test = Arrays.copyOf(arr,arr.length);
            time = quickSort(test);
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }
        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }


    public static void mergeTest(int number, int [] arr){
        System.out.println("Merge sort: ");
        long total = 0;
        long time = 0;
        for (int i = 1; i <=number ;i++){
            int [] test = Arrays.copyOf(arr,arr.length);
            time = mergeSort(test);
            total += time;
            System.out.println("Chay thu lan thu " + i + "  " + time);
        }
        System.out.println("Total = " + total);
        double tb =  (double) total / number;
        System.out.println("Average = " + tb);
    }

    // test random
    public static  void testRandom(int number){
        System.out.println("TEST RANDOM:");
        int [] arr = GetArray.randomIntegerArr();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test reverse
    public static  void testReverse(int number){
        System.out.println("TEST REVERSE:");
        int [] arr = GetArray.reverseSortedIntegerArray();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test sorted
    public static void testSorted(int number){
        System.out.println("TEST SORTED:");
        int [] arr = GetArray.sortedIntegerArr();
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
    // test equal
    public static  void testEqual(int n , int number){
        System.out.println("TEST EQUAL:");
        int [] arr = GetArray.equalIntegerArray(n);
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }


    public static void testTXT(String path , int number){
        System.out.println("TEST INPUT FROM FILE:" + path);
        int [] arr = GetArray.inputFromFile(path);
        insertTest(number, arr);
        quickTest(number,arr);
        mergeTest(number,arr);
    }
}
