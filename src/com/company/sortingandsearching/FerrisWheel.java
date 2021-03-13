package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Handles taking input and passing to solver method
 */
public class FerrisWheel {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        int n = reader.nextInt();
        int x = reader.nextInt();
        int[] weights = new int[n];
        for ( int i = 0; i < n; i++ ) {
            weights[i] = reader.nextInt();
        }
        System.out.println(new FerrisWheelSolver().solve(n,x,weights));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class FerrisWheelSolver {
    public int solve ( int n, int x, int[] weights ) {
        Arrays.sort(weights);
        int i = 0;
        int j = n - 1;
        int pairs = 0;
        while(i < j) {
            if(weights[i]+weights[j] > x) {
                j--;
            }
            else {
                i++;
                j--;
                pairs++;
            }
        }
        return (n-pairs);
    }

    /**
     * https://leetcode.com/problems/binary-search/solution/
     */
    private int binarySearch ( int[] weights, int target ) {
        int lo = 0;
        int hi = weights.length - 1;
        int mid = 0;

        while(lo <= hi) {
            mid = lo + (hi-lo)/2;
            if(weights[mid] == target) {
                return mid;
            }
            if(target < weights[mid]) {
                hi = mid-1;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}
