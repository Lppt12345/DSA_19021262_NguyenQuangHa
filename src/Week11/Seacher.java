package Week11;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Seacher {
    private static final int LENGTH = 6;
    private static final int SIZE = 20000;

    public static String randomString() {
        Random generator = new Random();
        char[] charArr = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            charArr[i] = (char) (generator.nextInt(26) + 97);
        }
        return String.valueOf(charArr);
    }
    public static void writeFile() throws IOException {
        FileWriter writer = new FileWriter("test.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i = 0; i < SIZE; i++) {
            buffer.write( randomString() + "\n");
        }
        buffer.close();
    }

    public static void main(String[] args) throws IOException {

        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        long start;
        long end;
//        writeFile();
        File file = new File("test.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String in = scan.nextLine();
            hashMap.put(in, in);
            arrayList.add(in);
        }
        scan.close();
        scan = new Scanner(System.in);
        System.out.print("Nhap : ");
        String input = scan.nextLine();
        scan.close();

        start = System.currentTimeMillis();
        System.out.println(arrayList.indexOf(input));
        end = System.currentTimeMillis();
        System.out.println("ArrayList mat " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(hashMap.get(input));
        end = System.currentTimeMillis();
        System.out.println("HashMap mat " + (end - start) + "ms");
    }
}
