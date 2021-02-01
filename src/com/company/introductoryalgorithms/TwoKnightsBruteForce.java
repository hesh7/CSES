package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class TwoKnightsBruteForce {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        for ( int i = 1; i <= n; i++ ) {
            System.out.println(new TwoKnightsBruteForceSolver().solve(i));
        }
    }

    /**
     * Contains core logic to solve the given problem
     */
    static class TwoKnightsBruteForceSolver {
        public long solve ( int n ) {
            long ans = 0;
            long searchSpace = n * n - 1;
            for ( int i = 1; i <= n; i++ ) {
                for ( int j = 1; j <= n; j++ ) {
                    int invalidCells = countInvalidCells(i, j, n);
                    ans += searchSpace - invalidCells;
                }
            }
            return ans / 2;
        }

        private int countInvalidCells ( int row, int col, int n ) {
            return ( ( ( row - 2 ) >= 1 && ( col + 1 ) <= n ) ? 1 : 0 ) +
                   ( ( ( row - 2 ) >= 1 && ( col - 1 ) >= 1 ) ? 1 : 0 ) +
                   ( ( ( row - 1 ) >= 1 && ( col + 2 ) <= n ) ? 1 : 0 ) +
                   ( ( ( row - 1 ) >= 1 && ( col - 2 ) >= 1 ) ? 1 : 0 ) +
                   ( ( ( row + 1 ) <= n && ( col + 2 ) <= n ) ? 1 : 0 ) +
                   ( ( ( row + 1 ) <= n && ( col - 2 ) >= 1 ) ? 1 : 0 ) +
                   ( ( ( row + 2 ) <= n && ( col + 1 ) <= n ) ? 1 : 0 ) +
                   ( ( ( row + 2 ) <= n && ( col - 1 ) >= 1 ) ? 1 : 0 );
        }
    }
}

