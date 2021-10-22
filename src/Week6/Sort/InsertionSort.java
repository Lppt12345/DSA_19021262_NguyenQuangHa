package Week6.Sort;

public class InsertionSort {
    private static void swap(Comparable a, Comparable b) {
        Comparable tmp = a;
        a = b;
        b = tmp;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    swap(a[j], a[j - 1]);
                } else {
                    break;
                }
            }
        }
    }
}