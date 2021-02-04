package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles taking input and passing to solver method
 */
public class GrayCode {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        System.out.println(new GrayCodeSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class GrayCodeSolver {
    public String solve ( int n ) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        result.add(0);
        sb.append(String.format("%" + n + "s", Integer.toBinaryString(0)).replace(' ', '0')).append("\n");
        for ( int i = 0; i < n; i++ ) {
            for ( int j = result.size() - 1; j >= 0; j-- ) {
                int nextGrayCodeNumber = result.get(j) | 1 << i;
                sb.append(String.format("%" + n + "s", Integer.toBinaryString(nextGrayCodeNumber)).replace(' ', '0')).append("\n");
                result.add(nextGrayCodeNumber);
            }
        }
        return sb.toString();
    }
}
