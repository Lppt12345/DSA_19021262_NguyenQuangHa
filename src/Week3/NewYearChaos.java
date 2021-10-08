package Week3;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++)
                if (q.get(j) > q.get(i)) {
                    count ++;
                    System.out.println(q.get(j));
                }

        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        List<Integer> list1 = List.of(2,1,5,3,4);
        minimumBribes(list1);
        List<Integer> list2 = List.of(2,5,1,3,4);
        minimumBribes(list2);
    }

}
