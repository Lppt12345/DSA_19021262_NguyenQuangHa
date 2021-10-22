package Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSortP1 {
    public static void printArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int temp = arr.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= temp) {
                int tp = arr.get(i);
                arr.set(i + 1, tp);
                printArray(arr);
            } else {
                arr.set(i + 1, temp);
                printArray(arr);
                break;
            }
        }
        if (arr.get(0) > temp){
            arr.set(1,arr.get(0));
            arr.set(0,temp);
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();
        insertionSort1(n, arr);
    }

// THAM KHAO
//
//    static void insertionSort1(int n, int[] arr) {
//        int last = arr[n - 1], i = n - 2;
//        while (i >= 0 && last < arr[i]) {
//            arr[i + 1] = arr[i--];
//            printArray(arr);
//        }
//        arr[i + 1] = last;
//        printArray(arr);
//    }
//
//    static void printArray(int[] arr) {
//        System.out.println(String.join(
//                " ",
//                Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)
//        ));
//    }
//
//    public static void main(String[] args) {
//        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 0};
//        insertionSort1(8, arr);
//    }
}
