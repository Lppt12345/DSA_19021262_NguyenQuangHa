package Week5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualStack {
    public static int ListSum(List <Integer> S){
        int sum = 0;
        for (int i :S){
            sum += i;
        }
        return sum;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int Sum1 = ListSum(h1);
        int Sum2 = ListSum(h2);
        int Sum3 = ListSum(h3);
        while (!(Sum1 == Sum2 && Sum2 == Sum3)) {
            int min = Math.min(Math.min(Sum1, Sum2), Sum3);
            if (Sum1 > min) {
                Sum1 -= h1.get(0);
                h1.remove(0);
            }
            if (Sum2 > min) {
                Sum2 -= h2.get(0);
                h2.remove(0);
            }
            if (Sum3 > min) {
                Sum3 -= h3.get(0);
                h3.remove(0);
            }
        }
        return Sum1;
    }
    public static void main(String[] args) {
        // tao copy cho cac mang

        List<Integer> h1 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1, 1));
        List<Integer> h2 = new ArrayList<Integer>(Arrays.asList(4, 3, 2));
        List<Integer> h3 = new ArrayList<Integer>(Arrays.asList(1, 1, 4, 1));
        System.out.println(equalStacks(h1, h2, h3));
    }
}
