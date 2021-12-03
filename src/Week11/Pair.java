package Week11;

import java.util.HashSet;
import java.util.List;

public class Pair {
    public static int pairs(int k, List<Integer> arr) {
        HashSet<Integer> set = new HashSet<>(arr);
        int pairs = 0;
        for (Integer i : arr) {
            if (set.contains(i - k)) {
                pairs++;
            }
        }
        return pairs;
    }
}
