package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles taking input and passing to solver method
 */
public class TwoSets {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final long n = reader.nextLong();
        System.out.println(new TwoSetsSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class TwoSetsSolver {
    public String solve ( long n ) {
        StringBuilder sb = new StringBuilder();
        long totalSum = (long) ( n * ( n + 1 ) ) / 2;
        if (totalSum % 2 != 0) {
            sb.append("NO");
        } else {
            sb.append("YES").append("\n");
            long sumInEachSet = totalSum / 2;
            ArrayList<Long> set1 = new ArrayList<>();
            long sumTillNow = 0;
            String x = "";
            long y = 1;
            if (sumInEachSet % n == 0) {
                x += n + " ";
                set1.add(n);
                sumTillNow += n;
            }
            while (sumInEachSet != sumTillNow) {
                if (sumInEachSet % n == 0) {
                    set1.add(n - y);
                    set1.add(y);
                    x += ( n - y ) + " " + y + " ";
                    sumTillNow += n;
                } else {
                    set1.add(n - y + 1);
                    set1.add(y);
                    x += ( n - y + 1 ) + " " + y + " ";
                    sumTillNow += n + 1;
                }
                y++;
            }
            sb.append(set1.size()).append("\n").append(x).append("\n");
            x = "";
            for ( long i = 1; i <= n; i++ ) {
                if (!set1.contains(i)) {
                    x += i + " ";
                }
            }
            sb.append(n - set1.size()).append("\n").append(x).append("\n");
        }
        return sb.toString();
    }
}
