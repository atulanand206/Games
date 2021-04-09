package com.games.CodeForces.theFestiveEvening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        char[] config = br.readLine().trim().toCharArray();
        int[] start = new int[26];
        Arrays.fill(start, -1);
        int[] end = new int[26];
        Arrays.fill(end, -1);
        for (int i = 0; i < config.length; i++) {
            char ch = config[i];
            if (start[ch - 65] == -1) start[ch - 65] = i;
        }
        for (int i = config.length - 1; i >= 0; i--) {
            char ch = config[i];
            if (end[ch - 65] == -1) end[ch - 65] = i;
        }
        Set<Character> openGates = new HashSet<>();
        for (int i = 0; i < config.length; i++) {
            char ch = config[i];
            if (start[ch - 65] == i)
                openGates.add(ch);
            if (openGates.size() > k) {
                System.out.println("YES");
                return;
            }
            if (end[ch - 65] == i)
                openGates.remove(ch);
        }

        System.out.println("NO");
    }
}
