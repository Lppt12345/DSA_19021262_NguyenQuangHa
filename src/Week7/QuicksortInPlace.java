package Week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuicksortInPlace {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i ++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;
        return i;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {return;}
        int pi = partition(arr, low, high);
        print(arr);
        sort(arr, low, pi - 1);
        sort(arr, pi + 1, high);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        sort(arr, 0 , n -1);
    }
}
