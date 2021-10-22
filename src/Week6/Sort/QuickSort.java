package Week6.Sort;

public class QuickSort {
    private static void swap(Comparable a, Comparable b) {
        Comparable tmp = a;
        a = b;
        b = tmp;
    }

    private static int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr[i], arr[j]);
            }
        }
        swap(arr[i + 1], arr[high]);
        return (i + 1);
    }

    public static void sort(Comparable[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
