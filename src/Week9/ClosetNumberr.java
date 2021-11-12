package Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MergeSort {
    public static void sort(Comparable[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Comparable[] l = new Comparable[mid];
        Comparable[] r = new Comparable[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        sort(l, mid);
        sort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(Comparable[] a, Comparable[] l, Comparable[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].compareTo(r[j]) <= 0) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}

class ClosestNumberr {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        Integer[] a = new Integer[arr.size()];
        arr.toArray(a);
        MergeSort.sort(a, a.length);
        List<Integer> returnArray = new ArrayList<Integer>();
        int minSpace = a[1] - a[0];
        returnArray.add(a[0]);
        returnArray.add(a[1]);
        for (int i = 2; i < arr.size(); i++) {
            if (a[i] - a[i - 1] < minSpace) {
                minSpace = a[i] - a[i - 1];
                returnArray.clear();
                returnArray.add(a[i - 1]);
                returnArray.add(a[i]);
            } else if (a[i] - a[i - 1] == minSpace) {
                returnArray.add(a[i - 1]);
                returnArray.add(a[i]);
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        scan.close();
        System.out.println(closestNumbers(arr));
    }
}