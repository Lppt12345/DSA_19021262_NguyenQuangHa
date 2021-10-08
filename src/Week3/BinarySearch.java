package Week3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {
    public static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        int input1 = test.nextInt();
        //
        // int[] randomArr = new Random().ints(0, 1000).limit(input1).toArray();
        int[] randomArr = new int[input1];
        for (int i = 0; i < input1; i++) {
            randomArr[i] = ThreadLocalRandom.current().nextInt(1, 1001);
        }
        Arrays.sort(randomArr);

        System.out.println("Arr = " + Arrays.toString(randomArr));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input2 = sc.nextInt();
            int result = binarySearch(randomArr, input2);
            if (result == -1) {
                System.out.println("-1");
            } else {
                System.out.println("Index " + result);
            }
        }
    }
}
