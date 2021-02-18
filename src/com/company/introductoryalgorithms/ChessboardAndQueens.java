package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class ChessboardAndQueens {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        boolean[][] blocked = new boolean[8][8];
        for(int i = 0; i < 8; i++) {
            final String n = reader.readLine();
            for ( int j = 0; j < n.length(); j++ ) {
                if (n.charAt(j) == '*') {
                    blocked[i][j] = true;
                }
            }
        }
        System.out.println(new ChessboardAndQueensSolver().solve(blocked,8));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class ChessboardAndQueensSolver {
    public int solve ( boolean[][] blocked, int n ) {
        int[] count = new int[1];

        //true -> Invalid cell
        //false -> Valid cell
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        int row = 0;

        for ( int i = 0; i < n; i++ ) {
            if(blocked[row][i]) {
                continue;
            }
            col[i] = true;
            diag1[i] = true;
            diag2[n - 1 - i] = true;

            backtrack(1, col, diag1, diag2, count, blocked,n);

            col[i] = false;
            diag1[i] = false;
            diag2[n - 1 - i] = false;
        }

        return count[0];

    }


    private void backtrack ( int r, boolean[] col, boolean[] diag1, boolean[] diag2, int[] count, boolean[][] blocked, int n ) {
        if (r == n) {
            return;
        }
        for ( int i = 0; i < n; i++ ) {
            if (col[i] || diag1[r + i] || diag2[r - i + n - 1] || blocked[r][i]) {
                continue;
            }
            if (r == n - 1) {
                count[0]++;
                return;
            }
            col[i] = true;
            diag1[r + i] = true;
            diag2[r - i + n - 1] = true;

            backtrack(r + 1, col, diag1, diag2, count, blocked, n);

            col[i] = false;
            diag1[r + i] = false;
            diag2[r - i + n - 1] = false;
        }
    }
}
