import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

public class Sum3 {
    public static void main(String[] args) {
        In in = new In("D:\\CTDL\\lib\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        for (int i = 0; i <= a.length; i++) {
            for (int j = i + 1; j <= a.length - 1; j++) {
                for (int k = j + 1; k <= a.length - 2; k++) {
                    if (a[i] + a[k] + a[j] == 0) {
                        System.out.println(a[i] + " and " + a[j] + " and " + a[k]);
                    }
                }
            }
        }

        StdArrayIO.print(a);

    }
}
