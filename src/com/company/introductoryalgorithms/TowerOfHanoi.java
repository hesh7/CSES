package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class TowerOfHanoi {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        System.out.println(new TowerOfHanoiSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class TowerOfHanoiSolver {
    public String solve ( int n ) {
        int[] count = new int[1];
        int start = 1;
        int end = 3;
        StringBuilder sb = new StringBuilder();
        hanoi(n, start, end, count, sb);
        return count[0] + "\n" + sb.toString();
    }

    /**
     * Recursive method used is given below:
     * hanoi(n,start,end) = { print(start,end) if n == 1  // Base Case
     *                        other = 6 - (start + end)
     *                        hanoi(n-1, start, other)
     *                        print(start,end)
     *                        hanoi(n-1,other,end)
     *                      }
     * Visualisation of recursion present in link - https://www.youtube.com/watch?v=rf6uf3jNjbo&ab_channel=Reducible
     */
    private void hanoi ( int n, int start, int end, int[] count, StringBuilder sb ) {
        count[0]++;
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        int other = 6 - ( start + end );
        hanoi(n - 1, start, other, count, sb);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(n - 1, other, end, count, sb);
    }
}
