package Week8;

import java.util.*;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        // Sap xep theo tang dan. co the thay doi bang Comparator interface
        Queue <Integer> queue = new PriorityQueue();
        for (int i = 0;i< A.size();i++){
            queue.add(A.get(i));
        }
        int count = 0;
        if (queue.peek() >= k){
            return 0;
        }
        while (queue.peek() < k){
            if (queue.size() == 1){
                return -1;
            }
            // remove element nem ngoai le poll vs peek thi ko
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a + b * 2);
            count ++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scan.nextInt());
        }
        scan.close();
        System.out.println(cookies(k, A));
    }
}
