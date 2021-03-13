package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.Arrays;

/**
 * Handles taking input and passing to solver method
 */
public class Apartments {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        //Number of applicants
        int n = reader.nextInt();
        //Number of apartments
        int m = reader.nextInt();
        //Max allowed diff
        int k = reader.nextInt();
        Integer[] desired = new Integer[n];
        for(int i = 0; i < n; i++) {
            desired[i] = reader.nextInt();
        }
        Integer[] apartments = new Integer[m];
        for(int i = 0; i < m; i++) {
            apartments[i] = reader.nextInt();
        }

        System.out.println(new ApartmentsSolver().solve(n,m,k,desired,apartments));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class ApartmentsSolver {
    public int solve ( int n, int m, int k, Integer[] desired, Integer[] apartments ) {
        int count = 0;
        Arrays.sort(apartments);
        Arrays.sort(desired);

        int j = 0;
        for ( int i = 0; i < n; i++ ) {
            while(j < m && apartments[j] < desired[i] - k) {
                j++;
            }
            if(j < m && apartments[j] <= desired[i] + k) {
                j++;
                count++;
            }
        }
        return count;
    }
}
