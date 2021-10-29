package Week7;

import java.util.Collections;
import java.util.List;

public class FindtheMedian {
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);     // NlogN
        return arr.get(arr.size() / 2);
    }
}
