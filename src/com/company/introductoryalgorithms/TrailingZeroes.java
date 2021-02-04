package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class TrailingZeroes {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        System.out.println(new TrailingZeroesSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class TrailingZeroesSolver {
    public int solve (int n) {
        int zeroCount = 0;
        while(n > 0) {
            n = n / 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
