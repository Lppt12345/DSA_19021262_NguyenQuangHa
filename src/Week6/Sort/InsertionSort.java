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
//    public static void insertionSort(Comparable[] objArray) {
//    // insertion sort starts from second element
//        for (int i = 1; i < objArray.length; i++) {
//            Comparable objectToSort = objArray[i];
//
//            int j = i;
//            while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
//                objArray[j] = objArray[j - 1];
//                j--;
//        }
//        objArray[j] = objectToSort;
//    }
//}
}