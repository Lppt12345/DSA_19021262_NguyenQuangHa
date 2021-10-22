package Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSortP2 {
    public static void insertionSortP1(int n, List<Integer> arr) {

        int temp = arr.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= temp) {
                int tp = arr.get(i);
                arr.set(i + 1, tp);
            } else {
                arr.set(i + 1, temp);
                break;
            }
        }
        if (arr.get(0) > temp){
            arr.set(1,arr.get(0));
            arr.set(0,temp);
        }
        printArray(arr);
    }

    private static void printArray(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    // Cach 1
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 2 ; i <= arr.size();i++){
            insertionSortP1(i , arr);
        }
    }
    // Cach 2
    public  static void InsertionSort2(int n, List <Integer> arr){
        for (int i =1 ;i< arr.size();i++){
            for (int j = i; j > 0 ;j--){
                if (arr.get(j) < arr.get(j-1)){
                    int tmp = arr.get(j);
                    arr.set(j , arr.get(j-1));
                    arr.set(j-1, tmp);
                }
            }
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
        List <Integer> tmp = new ArrayList<>(arr);
        sc.close();
        insertionSort2(n, arr);
        System.out.println("Cach 2:");
        InsertionSort2(n,tmp);
    }
}
