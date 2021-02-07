package com.company.introductoryalgorithms;

import com.company.util.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles taking input and passing to solver method
 */
public class CreatingStrings {
    public static void main ( String[] args ) throws IOException {
        final InputReader reader = new InputReader();
        final String n = reader.readLine();
        System.out.println(new CreatingStringsSolver().solve(n));
    }
}

/**
 * Contains core logic to solve the given problem
 */
class CreatingStringsSolver {
    public String solve ( String n ) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n.length()];
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        List<List<Character>> list = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        backtrack(list, tempList, chars, used);

        sb.append(list.size()).append("\n");
        for ( List<Character> arr : list ) {
            sb.append(arr.stream().map(Object::toString).collect(Collectors.joining())).append("\n");
        }
        return sb.toString();
    }

    private void backtrack ( List<List<Character>> list, List<Character> tempList, char[] chars, boolean[] used ) {
        if (tempList.size() == chars.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for ( int i = 0; i < chars.length; i++ ) {
                if (used[i] || i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(chars[i]);
                backtrack(list, tempList, chars, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
