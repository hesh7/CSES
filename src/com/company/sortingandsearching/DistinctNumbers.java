package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Handles taking input and passing to solver method
 */
public class DistinctNumbers {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        Set<Integer> hash_set = new HashSet<>(n);
        for(int i = 0; i < n; i++) {
            hash_set.add(reader.nextInt());
        }
        System.out.println(hash_set.size());
    }
}

/**
 * Contains core logic to solve the given problem
 */
class DistinctNumbersSolver {
    public String solve (int[] a) {
        return "";
    }
}
