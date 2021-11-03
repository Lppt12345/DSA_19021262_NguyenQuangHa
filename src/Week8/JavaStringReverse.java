package Week8;

import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        sc.close();
        boolean test = true;
        int n = A.length() - 1;
        int i = 0;
        while (test && i < n / 2) {
            if (A.charAt(i) != A.charAt(n - i)) {
                test = false;
                break;
            }
            i++;
        }
        if (test) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

//        String check = new String();
//        for (int i = A.length() - 1 ; i>=0 ;i --){
//            char c = A.charAt(i);
//            check += c;
//        }
//        if (check.equals(A)){
//            System.out.println("Yes");
//        }else {
//            System.out.println("No");
//        }
    }
}
