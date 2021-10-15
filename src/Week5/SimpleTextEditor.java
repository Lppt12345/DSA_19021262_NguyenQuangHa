package Week5;

import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        Stack<String> stack = new Stack<String>();
        stack.push(result);
        for (int i = 0; i < n; i++) {
            int query = sc.nextInt();
            switch (query){
                case 1:
                    result = result + sc.next();
                    // day het ket qua vao stack
                    stack.push(result);
                    break;
                case 2:
                    // xoa k phan tu cuoi
                    result = result.substring(0, result.length() - sc.nextInt());
                    stack.push(result);
                    break;
                case 3:
                    // in phan tu thu k. k la so nhap vao
                    System.out.println(result.charAt(sc.nextInt() - 1));
                    break;
                case 4:
                    stack.pop();
                    result = stack.peek();
                    break;
            }
        }
    }
}

