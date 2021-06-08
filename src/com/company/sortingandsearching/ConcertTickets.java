package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Handles taking input and passing to solver method
 */
public class ConcertTickets {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        TreeMap<Integer, Integer> prices = new TreeMap<>();
        for ( int i = 0; i < n; i++ ) {
            int x = reader.nextInt();
            prices.put(x, prices.getOrDefault(x, 0) + 1);
        }

        int[] maxPrice = new int[m];
        for ( int i = 0; i < m; i++ ) {
            maxPrice[i] = reader.nextInt();
        }

        System.out.println(new ConcertTicketsSolver().solve(prices, maxPrice));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class ConcertTicketsSolver {
    public String solve (TreeMap<Integer, Integer> prices, int[] maxPrice ) {
        StringBuilder sb = new StringBuilder();
        for ( int price : maxPrice ) {
            Integer nearestPrice = prices.floorKey(price);
            if (nearestPrice != null) {
                sb.append(nearestPrice).append("\n");
                int count = prices.get(nearestPrice) - 1;
                if (count > 0) prices.put(nearestPrice, count);
                else prices.remove(nearestPrice);
            } else {
                sb.append("-1").append("\n");
            }
        }
        return sb.toString();
    }
}
