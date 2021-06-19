package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class CollectingNumbers {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
            a[i]--;
            b[a[i]] = i;
        }
        System.out.println(new CollectingNumbersSolver().solve(b));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class CollectingNumbersSolver {
    public int solve ( int[] b ) {
        int count = 1;
        for(int i = 0 ; i < b.length-1; i++) {
            if(b[i] > b[i+1]) count++;
        }
        return count;
    }
}
