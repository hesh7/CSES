package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class CoinPiles {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        for ( int i = 1; i <= n; i++ ) {
            final int a = reader.nextInt();
            final int b = reader.nextInt();
            System.out.println(new CoinPilesSolver().solve(a, b));
        }

    }
}

/**
 * Contains core logic to solve the given problem
 */
class CoinPilesSolver {
    public String solve ( int a, int b ) {
        //Suppose we take coins m times using approach 1, and n times using approach 2. Then solving simultaneous equation,
        // we get m = (2*b - a) / 3, and n = (2*a - b) / 3.
        if(((2*b - a) >= 0) && ((2*b - a)%3 == 0) && ((2*a - b) >= 0) && ((2*a - b)%3 == 0)) {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
