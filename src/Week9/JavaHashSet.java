package Week9;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        HashSet<String> pairs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            input.replace(" ", "");
            pairs.add(input);
            System.out.println(pairs.size());
        }
        scan.close();
    }
}
