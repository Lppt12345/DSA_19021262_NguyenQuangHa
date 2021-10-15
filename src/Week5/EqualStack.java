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
    // Tham khao
//    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
//        int sum1 = 0, sum2 = 0, sum3 = 0;
//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        Stack<Integer> s3 = new Stack<>();
//
//        for (int i = h1.size() - 1; i >= 0; i--) {
//            s1.push(h1.get(i));
//            sum1 += h1.get(i);
//        }
//        for (int i = h2.size() - 1; i >= 0; i--) {
//            s2.push(h2.get(i));
//            sum2 += h2.get(i);
//        }
//        for (int i = h3.size() - 1; i >= 0; i--) {
//            s3.push(h3.get(i));
//            sum3 += h3.get(i);
//        }
//
//        while (!s1.empty() && !s2.empty() && !s3.empty()) {
//            int min = Math.min(sum1, Math.min(sum2, sum3));
//
//            if (sum1 > min) {
//                sum1 -= s1.pop();
//            }
//            if (sum2 > min) {
//                sum2 -= s2.pop();
//            }
//            if (sum3 > min) {
//                sum3 -= s3.pop();
//            }
//
//            if (sum1 == sum2 && sum2 == sum3) {
//                return sum1;
//            }
//        }
//
//        return 0;
//    }
}
