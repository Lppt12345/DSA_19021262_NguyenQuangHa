package Week6.Sort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class Test {

    public static void main (String [] args){
        // TXT
        Sort.testTXT("lib/algs4-data/1Kints.txt" , 10 );
        System.out.println("################################################");
        Sort.testTXT("lib/algs4-data/2Kints.txt" , 3 );
        System.out.println("################################################");
        Sort.testTXT("lib/algs4-data/4Kints.txt" , 3 );
        System.out.println("################################################");
        Sort.testTXT("lib/algs4-data/8Kints.txt" , 3 );
        System.out.println("################################################");
        Sort.testTXT("lib/algs4-data/16Kints.txt" , 3 );
        System.out.println("################################################");
        Sort.testTXT("lib/algs4-data/32Kints.txt" , 3 );
        //  RANDOM
        System.out.println("################################################");
        Sort.testRandom(7);
        // REVERSE
        System.out.println("################################################");
        Sort.testReverse(5);
        // SORTED
        System.out.println("################################################");
        Sort.testSorted(5);
        // EQUAL
        System.out.println("################################################");
        Sort.testEqual(5555,5);
    }

}
