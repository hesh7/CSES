package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class MaximumArraySum {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        int n = reader.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = reader.nextInt();
        System.out.println(new MaximumArraySumSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class MaximumArraySumSolver {
    public long solve ( int[] arr ) {
        long maxSoFar = Integer.MIN_VALUE;
        long sum = 0;
        for(int x : arr) {
            sum+=x;
            maxSoFar = Math.max(sum,maxSoFar);
            if(sum < 0) sum = 0;
        }
        return maxSoFar;
    }
}
