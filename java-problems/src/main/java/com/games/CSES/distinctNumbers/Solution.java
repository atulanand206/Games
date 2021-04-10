package com.games.CSES.distinctNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        String[] s = sc.readLine().trim().split(" ");
        Set<Long> set = new HashSet<>();
        while (--n >= 0) set.add(Long.parseLong(s[n]));
        System.out.println(set.size());
    }
}
