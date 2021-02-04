package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class PalindromeReorder {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final String n = reader.readLine();
        System.out.println(new PalindromeReorderSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class PalindromeReorderSolver {
    public String solve ( String n ) {
        int[] frequencyArr = new int[26];
        for ( int i = 0; i < n.length(); i++ ) {
            frequencyArr[n.charAt(i) - 'A']++;
        }
        int oddCharCount = 0;
        char oddCharacter = 0;
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 26; i++ ) {
            if (frequencyArr[i] % 2 != 0) {
                if (oddCharCount != 0) {
                    return "NO SOLUTION";
                } else {
                    oddCharCount++;
                    oddCharacter = (char) ( 'A' + i );
                }
            } else {
                for ( int j = 1; j <= frequencyArr[i] / 2; j++ ) {
                    sb.append((char) ( 'A' + i ));
                }
            }
        }
        String x = sb.toString();
        if (oddCharCount != 0) {
            for ( int i = 1; i <= frequencyArr[oddCharacter - 'A']; i++ ) {
                sb.append(oddCharacter);
            }
        }
        sb.append(reverse(x));
        return sb.toString();
    }

    private String reverse ( String x ) {
        StringBuilder sb = new StringBuilder();
        for ( int i = x.length() - 1; i >= 0; i-- ) {
            sb.append(x.charAt(i));
        }
        return sb.toString();
    }
}
