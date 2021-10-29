package Week7;

import java.util.List;

public class Quicksort1_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        int pivot = 0;
        int left = pivot + 1;
        int right = arr.size() - 1;

        while (true) {
            while (arr.get(left) < arr.get(pivot) && left <= right) {
               left ++;  // tim phan tu <= arr[pivot]
            }
            while (arr.get(right) > arr.get(pivot) && right >= left) {
                right --;  // tim phan tu >= arr[pivot]
            }
            if (left >= right) {
                break;
            }
            int tmp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, tmp);
//          left ++ ; // tang left vi da xet
//          right --; //  giam right
        }

        int tmp = arr.get(right);
        arr.set(right, arr.get(pivot));
        arr.set(pivot, tmp);
        return arr;
    }
}
