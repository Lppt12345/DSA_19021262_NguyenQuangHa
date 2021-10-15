package Week5;

import edu.princeton.cs.algs4.In;

import java.util.Scanner;
import java.util.Stack;

public class QueueusingTwoStack {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int query = sc.nextInt();

            switch (query) {
                case 1:
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
        }
    }

    public static class MyQueue<Interger> {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();


        public void enqueue(Integer num){
            // push du lieu stack 2 len va go bo du lieu cua no
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
            // dua num vao stack 2
            stack2.push(num);
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        public void dequeue() {
            stack2.pop();
        }

        public int peek() {
            return stack2.peek();
        }

    }
}
