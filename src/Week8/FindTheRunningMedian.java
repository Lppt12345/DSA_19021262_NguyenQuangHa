package Week8;

import java.text.DecimalFormat;
import java.util.*;

public class FindTheRunningMedian {

    // Co che chia day thanh 2 nua lay min nua sau va max nua truoc
    public static List<Double> runningMedian(List<Integer> a) {
//        DecimalFormat df = new DecimalFormat("0.00");
        int N = a.size();
        List<Double> result = new ArrayList<>();
        // Chia ra 2 day tang giam. maxPQ lay phan tu lon nhat minPQ lay phan tu nho nhat
        Queue<Integer> maxPQ = new PriorityQueue<>(N/2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue<>(N/2 + 1);
        maxPQ.add(a.get(0));
        double prev = (double) a.get(0);
        int i = 1;
        result.add(prev);

        while (i < N) {
            // Neu lon hon thi xep no vao nua sau (minPQ: cac so lon hon no ) be hon xep vao nua truoc (maxPQ: cac so be hon no)
            if (a.get(i) >= prev){
                minPQ.add(a.get(i));
                i++;
            }else {
                maxPQ.add(a.get(i));
                i++;
            }

            // Can doi de dam bao 2 day luon chenh nhau max <= 1
            if (maxPQ.size() > minPQ.size()){
                minPQ.add(maxPQ.remove());
            }else if (minPQ.size() > maxPQ.size()){
                maxPQ.add(minPQ.remove());
            }

            if (maxPQ.size() > minPQ.size()) {
                prev = maxPQ.peek();
            } else if (maxPQ.size() < minPQ.size()) {
                prev = minPQ.peek();
            } else {
                prev = (maxPQ.peek() + minPQ.peek()) / (double) 2;
            }

            result.add(prev);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scan.nextInt());
        }
        scan.close();
        System.out.println(runningMedian(A));
    }
}
