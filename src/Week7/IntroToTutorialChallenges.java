package Week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroToTutorialChallenges {
    public static int introTutorial(int V, List<Integer> arr) {
        int N = arr.size();
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) > V) {
                hi = mid - 1;
            } else if (arr.get(mid) < V) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int n = scan.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }
        scan.close();
        System.out.println(introTutorial(V, arr));
    }
}
