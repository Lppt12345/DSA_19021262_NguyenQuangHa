package Week3;

import java.util.Collections;
import java.util.List;

public class Pair {
    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int i = 0, j = 1, count = 0;
        while (i < arr.size() && j < arr.size()) {
            if (arr.get(j) - arr.get(i) == k) {
                j++;
                count++;
            } else if (arr.get(j) - arr.get(i) < k) {
                j++;
            } else if (arr.get(j) - arr.get(i) > k) {
                i++;
            }
        }
        return count;
    }

}


// THAM KHAO
//    static int pairs(int k, int[] arr)
//    {
//        int count = 0;
//        HashSet<Integer> set = new HashSet<>();
//        for(int num : arr)
//        {
//            set.add(num);
//        }
//
//        for(int number : arr)
//        {
//            if(set.contains(number + k))
//            {
//                count++;
//            }
//        }
//        return count;
//    }

}
