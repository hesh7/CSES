package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;

/**
 * Handles taking input and passing to solver method
 */
public class Permutations {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        new PermutationsSolver().solve(n);
    }
}

/**
 * Contains core logic to solve the given problem
 */
class PermutationsSolver {
    public void solve ( int n ) {
        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        if (n == 1) {
            System.out.println("1");
            return;
        }
        int[] arr = new int[n];
        int mid = n % 2 == 0 ? n / 2 : ( n - 1 ) / 2;
        arr[mid] = n;
        arr[mid + 1] = n - 2;
        arr[mid - 1] = n - 3;
        arr[mid - 2] = n - 1;
        if (mid - 3 >= 0)
            arr[mid - 3] = arr[mid - 2] - 4;

        for ( int i = mid - 4; i >= 0; i-- ) {
            arr[i] = arr[i + 1] - 2;
        }

        for ( int i = mid + 2; i < n; i++ ) {
            arr[i] = arr[i - 1] - 2;
        }

        StringBuilder sb = new StringBuilder();
        for ( int j : arr ) {
            sb.append(j);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
