package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class Repetitions {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final String n = reader.readLine();
        System.out.println(new RepetitionsSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class RepetitionsSolver {
    public int solve ( String n ) {
        int[] arr = new int[26];
        arr[n.charAt(0) - 'A'] += 1;
        int maxTillNow = 1;

        for ( int i = 1; i < n.length(); i++ ) {
            char c = n.charAt(i);
            if(c == n.charAt(i-1)) {
                arr[c-'A']++;
            }
            else {
                arr[c-'A'] = 1;
            }
            maxTillNow = Math.max(maxTillNow, arr[c-'A']);
        }
        return maxTillNow;
    }
}