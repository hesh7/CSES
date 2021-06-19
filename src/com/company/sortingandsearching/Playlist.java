package com.company.sortingandsearching;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles taking input and passing to solver method
 */
public class Playlist {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final int n = reader.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++) arr[i] = reader.nextInt();
        System.out.println(new PlaylistSolver().solve(arr));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class PlaylistSolver {
    public int solve ( int[] arr ) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        int left = 0;
        int ans = 1;
        indexMap.put(arr[0],0);
        for(int i = 1; i < arr.length; i++) {
            if(indexMap.containsKey(arr[i])) {
                int index = indexMap.get(arr[i]);
                left = index >= left ? indexMap.get(arr[i]) + 1 : left;
            }

            indexMap.put(arr[i],i);
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }
}