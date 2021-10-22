package Week6.Sort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class Test {

    public static void main (String [] args){
        // TXT
        Sort.testTXT("lib/algs4-data/1Kints.txt" , 3 );
        Sort.testTXT("lib/algs4-data/2Kints.txt" , 3 );
        Sort.testTXT("lib/algs4-data/4Kints.txt" , 3 );
        Sort.testTXT("lib/algs4-data/8Kints.txt" , 3 );
        Sort.testTXT("lib/algs4-data/16Kints.txt" , 3 );
        Sort.testTXT("lib/algs4-data/32Kints.txt" , 3 );
        // RANDOM
        Sort.testRandom(5);
        // REVERSE
        Sort.testReverse(5);
        // SORTED
        Sort.testSorted(5);
        // EQUAL
        Sort.testEqual(5555,5);
    }

}
