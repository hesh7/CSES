package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class DigitQueries {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int q = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < q; i++ ) {
            long index = reader.nextLong();
            sb.append(new DigitQueriesSolver().solve(index)).append("\n");
        }
        System.out.println(sb.toString());
    }
}

/**
 * Contains core logic to solve the given problem
 */
class DigitQueriesSolver {
    public char solve ( long n ) {
        long start = 1;
        long num = 9;
        long len = 1;

        while (n > len * num) {
            n -= len * num;
            num *= 10;
            len += 1;
            start *= 10;
        }
        String finalNum = Long.toString(start + ( n - 1 ) / len);
        return finalNum.charAt((int) ( ( n - 1 ) % len ));
    }
}