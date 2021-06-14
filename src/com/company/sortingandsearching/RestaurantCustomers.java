package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.*;

/**
 * Handles taking input and passing to solver method
 */
public class RestaurantCustomers {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        List<Pair> customers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            customers.add(new Pair(reader.nextInt(),1));
            customers.add(new Pair(reader.nextInt(),-1));
        }
        System.out.println(new Solver().solve(customers));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class Solver {
    public int solve ( List<Pair> customers ) {
        //https://stackoverflow.com/questions/4805606/how-to-sort-by-two-fields-in-java
        Collections.sort(customers, new Comparator() {
            public int compare(Object o1, Object o2) {
                Pair p1 = (Pair)o1;
                Pair p2 = (Pair)o2;
                if(p1.a != p2.a) {
                    return p1.a < p2.a ? -1 : 1;
                }
                return p1.b < p2.b ? -1 : 1;
            }
        });

        int maxCount = 0;
        int count = 0;
        for(Pair p : customers) {
            count+=p.b;
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}

class Pair {
    public int a;
    public int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
