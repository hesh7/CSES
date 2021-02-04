package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class BitStrings {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        System.out.println(new BitStringsSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class BitStringsSolver {
    public long solve ( int n ) {
        long ans = 1;
        long max = 1000000007;
        for ( int i = 1; i <= n; i++ ) {
            ans = ( ans % max * 2 ) % max;
        }
        return ans;
    }
}
