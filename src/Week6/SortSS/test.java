package Week6.SortSS;

import Week6.Sort.Sort;

public class test {
    public static void main (String [] args){
        // TXT
        Week6.Sort.Sort.testTXT("lib/algs4-data/1Kints.txt" , 10 );
        System.out.println("################################################");
        Week6.Sort.Sort.testTXT("lib/algs4-data/2Kints.txt" , 3 );
        System.out.println("################################################");
        Week6.Sort.Sort.testTXT("lib/algs4-data/4Kints.txt" , 3 );
        System.out.println("################################################");
        Week6.Sort.Sort.testTXT("lib/algs4-data/8Kints.txt" , 3 );
        System.out.println("################################################");
        Week6.Sort.Sort.testTXT("lib/algs4-data/16Kints.txt" , 3 );
        System.out.println("################################################");
        Week6.Sort.Sort.testTXT("lib/algs4-data/32Kints.txt" , 3 );
        //  RANDOM
        System.out.println("################################################");
        Week6.Sort.Sort.testRandom(7);
        // REVERSE
        System.out.println("################################################");
        Week6.Sort.Sort.testReverse(5);
        // SORTED
        System.out.println("################################################");
        Week6.Sort.Sort.testSorted(5);
        // EQUAL
        System.out.println("################################################");
        Sort.testEqual(5555,5);
    }

}
