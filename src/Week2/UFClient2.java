import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {

        int N = StdIn.readInt();

        UF uf = new UF(N);
        int check = 0;
        int line = 0;
        while (!StdIn.isEmpty()) {
            line++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                check ++;
                if (check>=N-1){
                    StdOut.println(line);
                    return;
                }
            }
        }
        if (check <N-1) {
            StdOut.println("FAILED");
        }

    }
}
