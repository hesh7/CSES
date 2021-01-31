package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class IncreasingArray {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = reader.nextInt();
        }
        System.out.println(new IncreasingArraySolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class IncreasingArraySolver {
    public long solve ( int[] arr ) {
        int maxSoFar = 0;
        long reqdVal = 0;
        for ( int x : arr ) {
            maxSoFar = Math.max(maxSoFar, x);
            reqdVal += maxSoFar - x;
        }
        return reqdVal;
    }
}