package Week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            String number = scan.nextLine();
            phoneBook.put(name, number);
        }
        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            if (phoneBook.containsKey(name)) {
                System.out.println(name + "=" + phoneBook.get(name));
            } else {
                System.out.println("Not found");
            }
        }
        scan.close();
    }
}
