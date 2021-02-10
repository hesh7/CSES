package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class AppleDivision {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++ ) {
            arr[i] = reader.nextInt();
        }
        System.out.println(new AppleDivisionSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class AppleDivisionSolver {
    public long solve ( int[] arr ) {
        long totalSum = 0;
        long sumCalculated = 0;
        for ( int k : arr ) {
            totalSum += k;
        }
        return findMinDiff(arr, arr.length - 1, sumCalculated, totalSum);
    }

    /**
     * findMinDiff(arr,n,sumCalculated,totalSum) = { abs(totalSum - 2*sumCalculated, if n == 0,
     * <p>
     * min(findMinDiff(arr,n-1,sumCalculated+arr[n],totalSum), //In current subset we considered keeping nth element
     * findMinDiff(arr,n-1,sumCalculated,totalSum)) // In current subset we didn't keep nth element
     * <p>
     * }
     */
    private long findMinDiff ( int[] arr, int i, long sumCalculated, long totalSum ) {

        if (i == 0) {
            return Math.abs(totalSum - 2 * sumCalculated);
        }

        return Math.min(findMinDiff(arr, i - 1, sumCalculated + arr[i], totalSum), findMinDiff(arr, i - 1, sumCalculated, totalSum));

    }
}