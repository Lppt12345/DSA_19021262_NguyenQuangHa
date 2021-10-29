package Week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List <Integer> result = new ArrayList<>(Collections.nCopies(100, 0));
        for (int i =0 ; i<arr.size(); i++ ){
            int index = arr.get(i);
            result.set(index, result.get(index) + 1);
        }
        return result;
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
