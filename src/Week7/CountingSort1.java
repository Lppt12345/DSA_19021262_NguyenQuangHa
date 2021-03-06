package Week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List <Integer> count = new ArrayList<>(Collections.nCopies(100, 0));
        for (int i =0 ; i<arr.size(); i++ ){
            count.set(arr.get(i), count.get(arr.get(i)) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> arr  = new ArrayList<>();
        for (int i =0 ;i <n;i++){
            arr.add(sc.nextInt());
        }
        sc.close();
        System.out.println(countingSort(arr));
    }
}
