package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class GridPaths {
    public static void main ( String[] args ) throws IOException {
//        final InputReader reader = new InputReader();
//        final String n = reader.readLine();
//        System.out.println(new GridPathsSolver().solve(n));
        Character c = 's';
        Character.toUpperCase(c);
        System.out.println(c);
    }
}

/**
 * Contains core logic to solve the given problem
 */
class GridPathsSolver {
    static int count = 0;

    public int solve ( String n ) {
        int row = 0;
        int col = 0;
        int index = 0;
        int maxGridSize = 7;
        int strLen = n.length();
        boolean[][] visited = new boolean[maxGridSize][maxGridSize];
        findGridPaths(index, row, col, n, maxGridSize, visited, strLen);
        return count;
    }

    private void findGridPaths ( int index, int row, int col, String n, int maxGridSize, boolean[][] visited, int strLen ) {
        if (row == maxGridSize - 1 && col == 0 && index == strLen) {
            count++;
            return;
        }
        if (!isValid(row, col, maxGridSize, visited, index, strLen)) {
            return;
        }

        visited[row][col] = true;
        char direction = n.charAt(index);
        if (direction == '?') {
            findGridPaths(index + 1, row + 1, col, n, maxGridSize, visited, strLen);
            findGridPaths(index + 1, row - 1, col, n, maxGridSize, visited, strLen);
            findGridPaths(index + 1, row, col + 1, n, maxGridSize, visited, strLen);
            findGridPaths(index + 1, row, col - 1, n, maxGridSize, visited, strLen);
        } else {
            if (direction == 'D') {
                findGridPaths(index + 1, row + 1, col, n, maxGridSize, visited, strLen);
            } else if (direction == 'U') {
                findGridPaths(index + 1, row - 1, col, n, maxGridSize, visited, strLen);
            } else if (direction == 'R') {
                findGridPaths(index + 1, row, col + 1, n, maxGridSize, visited, strLen);
            } else if (direction == 'L') {
                findGridPaths(index + 1, row, col - 1, n, maxGridSize, visited, strLen);
            }
        }
        visited[row][col] = false;
    }

    private boolean isValid ( int row, int col, int maxGridSize, boolean[][] visited, int index, int strLen ) {
        return row >= 0 && row < maxGridSize && col >= 0 && col < maxGridSize && !visited[row][col] && index < strLen;
    }
}

