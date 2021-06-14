package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Handles taking input and passing to solver method
 */
public class MovieFestival {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        int n = reader.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = reader.nextInt();
            intervals[i][1] = reader.nextInt();
        }
        System.out.println(new MovieFestivalSolver().solve(intervals));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class MovieFestivalSolver {
    class MyComparator implements Comparator<int[]> {
        public int compare ( int[] a, int[] b ) {
            return a[1] - b[1];
        }
    }

    public int solve ( int[][] intervals ) {
        Arrays.sort(intervals, new MyComparator());
        int last = 0;
        int count = 0;
        for(int[] x : intervals) {
            if(x[0] >= last) {
                count++;
                last = x[1];
            }
        }
        return count;
    }
}