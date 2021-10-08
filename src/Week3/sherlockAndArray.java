package Week3;

import java.util.List;

public class sherlockAndArray {
    static String balancedSums(List<Integer> arr) {
        int sum = 0;
        // tinh tong tat ca phan tu
        for (int x : arr){
            sum += x;
        }
        int left = 0;
        // tinh tong ve trai
        for (int x: arr){
            sum -= x;
            if(left == sum) {
                return " YES ";
            }
            left += x;
        }
        return " NO ";
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 1, 4, 1, 1);
        List<Integer> list2 = List.of(2, 0, 0, 0);
        List<Integer> list3 = List.of(0, 0, 2, 0);

        System.out.println(list1 + balancedSums(list1));
        System.out.println(list2 + balancedSums(list2));
        System.out.println(list3 + balancedSums(list3));
    }
}