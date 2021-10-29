package Week7;

import java.util.List;

public class Quicksort1_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        int pivot = 0;
        int i = pivot;
        int j = arr.size();

        while (true) {
            while (arr.get(++i) < arr.get(pivot)) {
                if (i == arr.size()) {
                    break;
                }
            }
            while (arr.get(--j) > arr.get(pivot)) {
                if (j == 0) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }

        int tmp = arr.get(j);
        arr.set(j, arr.get(pivot));
        arr.set(pivot, tmp);

        return arr;
    }
}
