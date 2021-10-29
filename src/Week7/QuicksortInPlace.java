package Week7;

import java.util.Scanner;

public class QuicksortInPlace {
    static int partition(int arr[], int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        print(arr);
        return i;
    }

    static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {return;}
        int mid = partition(arr, lo, hi);
        sort(arr, lo, mid - 1);
        sort(arr, mid + 1, hi);
    }

    static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
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
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
