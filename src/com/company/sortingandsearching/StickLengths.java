package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Handles taking input and passing to solver method
 */
public class StickLengths {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = reader.nextInt();
        }
        System.out.println(new StickLengthsSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class StickLengthsSolver {
    public long solve ( int[] arr ) {
        Arrays.sort(arr);
        int n = arr.length;
        int val = arr[n/2];
        long ans = 0;
        for(int x : arr) ans+=Math.abs(val-x);
        return ans;
    }
}