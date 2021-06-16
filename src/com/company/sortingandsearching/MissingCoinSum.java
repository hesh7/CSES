package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Handles taking input and passing to solver method
 */
public class MissingCoinSum {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = reader.nextInt();
        System.out.println(new MissingCoinSumSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class MissingCoinSumSolver {
    public long solve ( int[] arr ) {
        Arrays.sort(arr);
        long currSum = 0;
        for(int x : arr) {
            if((currSum + 1) < x) return currSum+1;
            currSum = currSum + x;
        }
        return currSum+1;
    }
}