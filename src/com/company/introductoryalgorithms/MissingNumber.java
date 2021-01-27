package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class MissingNumber {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i < n - 1; i++ ) arr[i] = reader.nextInt();
        System.out.println(new MissingNumberSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class MissingNumberSolver {
    public int solve ( int[] arr ) {
        int requiredSum = 1;
        int n = arr.length;
        for ( int i = 2; i <= n; i++ ) {
            requiredSum += i;
            requiredSum -= arr[i - 2];
        }
        return requiredSum;
    }
}