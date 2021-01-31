package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class NumberSpiral {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        for ( int i = 1; i <= n; i++ ) {
            long r = reader.nextInt();
            long c = reader.nextInt();
            System.out.println(new NumberSpiralSolver().solve(r, c));
        }
    }
}

/**
 * Contains core logic to solve the given problem
 */
class NumberSpiralSolver {
    public long solve ( long r, long c ) {
        long val = 0;
        if (r > c) {
            if (r % 2 == 0) {
                val = r * r - c + 1;
            } else {
                val = ( r - 1 ) * ( r - 1 ) + c;
            }
        } else {
            if (c % 2 == 0) {
                val = ( c - 1 ) * ( c - 1 ) + r;
            } else {
                val = c * c - r + 1;
            }
        }
        return val;
    }
}
