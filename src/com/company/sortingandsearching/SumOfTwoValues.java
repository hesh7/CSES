package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Handles taking input and passing to solver method
 */
public class SumOfTwoValues {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        int n = reader.nextInt();
        int target = reader.nextInt();
        int[][] val = new int[n][2];
        for(int i = 0; i < n; i++) {
            val[i][0] = reader.nextInt();
            val[i][1] = i+1;
        }
        System.out.println(new SumOfTwoValuesSolver().solve(val,target));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class SumOfTwoValuesSolver {
    class MyComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
    public String solve ( int[][] val, int target ) {
        Arrays.sort(val,new MyComparator());
        int lo = 0;
        int hi = val.length - 1;
        int sum;
        while(lo < hi) {
            sum = val[lo][0] + val[hi][0];
            if(sum < target) {
                lo++;
            }
            else if(sum > target) {
                hi--;
            }
            else {
                return val[lo][1] + " " + val[hi][1];
            }
        }
        return "IMPOSSIBLE";
    }
}