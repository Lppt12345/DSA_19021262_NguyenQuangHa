package Week3;

import java.util.*;

public class ClosestNumbers {
    static  List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);

        List<Integer> result = new ArrayList<Integer>();
        // gan gia tri nho nhat
        int minDiff = arr.get(1) - arr.get(0);

        // duyet mang xem cai nao nho hon cai nho nhat de tim cai nho nhat
        for (int i = 2; i < arr.size(); i++) {
            minDiff = Math.min(minDiff, arr.get(i) - arr.get(i-1));
        }
        // in ra cai nho nhat
        for (int i = 1; i < arr.size(); i++) {
            if ((arr.get(i) - arr.get(i-1)) == minDiff) {
                result.add(arr.get(i-1));
                result.add(arr.get(i));
            }
        }
        return result;
    }
}
