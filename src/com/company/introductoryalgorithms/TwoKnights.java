package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class TwoKnights {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        System.out.println(new TwoKnightsSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class TwoKnightsSolver {
    public String solve ( int n ) {
        // Total number of ways to arrange two knights in a n*n chessboard = (n^2)C2 = (n^2)(n^2 - 1) / 2
        // Total number of 2 * 3 regions in a n * n chess board = (n - 1) * (n - 2)
        // Total number of 3 * 2 regions in a n * n chess board = (n - 2) * (n - 1)
        // Total number of 2 * 3 and 3 * 2 regions in a n * n chess board = 2(n-1)(n-2)
        // Inside each 2 * 3 and 3 * 2 region, there are two types of position where two knights can be placed and they attack each other.
        // So, total number of ways in which two knights attack each other in a n * n chess board = 2 * 2(n-1)(n-2) = 4(n-1)(n-2)
        // Therefore, final ans = Total number of ways to arrange two knights in a n*n chessboard - total number of ways in which two knights attack each other in a n * n chess board
        // = [ (n^2)C2 = (n^2)(n^2 - 1) / 2 ] - 4(n-1)(n-2)

        long ans = 0;
        StringBuilder sb = new StringBuilder();
        for ( long i = 1; i <= n; i++ ) {
            ans = ( ( i * i ) * ( i * i - 1 ) ) / 2 - 4 * ( i - 1 ) * ( i - 2 );
            sb.append(ans);
            sb.append("\n");
        }
        return sb.toString();
    }
}
