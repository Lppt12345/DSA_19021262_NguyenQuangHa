package Week11;

import java.util.*;

public class MissingNumber {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Hashtable<Integer, Integer> a = new Hashtable<>();
        Hashtable<Integer, Integer> b = new Hashtable<>();
        ArrayList<Integer> result = new ArrayList<>();
        // n
        for (Integer i : arr) {
            if (!a.containsKey(i)) {

                a.put(i, 1);
            } else {
                a.put(i, a.get(i) + 1);
            }
        }
        // n
        for (Integer i : brr) {
            if (!b.containsKey(i)) {
                b.put(i, 1);
            } else {
                b.put(i, b.get(i) + 1);
            }
        }

        for (Integer i : b.keySet()) {
            if (!a.containsKey(i)) {
                result.add(i);
            } else {
                if (!a.get(i).equals(b.get(i))) {
                    result.add(i);
                }
            }
        }
        // nlogn
        Collections.sort(result);
        return result;
    }
    // sort
    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        ArrayList<Integer> result = new ArrayList<>();
        // 2nlogn
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0;
        for (Integer n : brr) {
            if (i >= arr.size() || !arr.get(i).equals(n)) {
                if (!result.contains(n)) {
                    result.add(n);
                }
            } else {
                i++;
            }
        }
        return result;
    }
    // Counting sort
    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
        List<Integer> a = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) a.add(0);
        int min = brr.get(0);
        for (Integer i : brr){
            if (i < min){
                min = i;
            }
        }
        for (Integer i : brr) {
            a.set(i - min, a.get(i - min) + 1);
        }
        for (Integer i : arr){
            a.set(i - min, a.get(i - min) - 1);
        }
        for (int i = 0; i < 100; i++){
            if (a.get(i) != 0) result.add(i + min);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        int m = scan.nextInt();
        ArrayList<Integer> brr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            brr.add(scan.nextInt());
        }
        scan.close();
        System.out.println(missingNumbers(arr, brr));
    }
}
