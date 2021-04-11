package com.games.CF.cakeWalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Set<Character> set = new HashSet<>();
            List<Character> chars = new ArrayList<>();
            for (char ch : s.toCharArray())
                if (!set.contains(ch)) {
                    set.add(ch);
                    chars.add(ch);
                }
            for (Character ch : chars)
                System.out.print(ch);
            System.out.println();
        }
    }
}
