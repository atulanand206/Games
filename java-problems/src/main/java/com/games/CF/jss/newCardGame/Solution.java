package com.games.CF.jss.newCardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = br.readLine().split(" ");
        int n = Integer.parseInt(ns[0]);
        int[] it = new int[n];
        for (int i = 1; i < ns.length; i++) it[i - 1] = Integer.parseInt(ns[i]);
        int[] s = new int[n];
        s[0] = it[0];
        for (int i = 1; i < n; i++) s[i] = s[i - 1] + it[i];
        int min = Integer.MAX_VALUE;
        int sum = s[s.length - 1];
        int[] k = new int[n];
        for (int i = 0; i < n; i++) k[i] = (sum - 2 * s[i]);
        for (int i = 0; i < n; i++) if (k[i] < min && k[i] > 0) min = k[i];
        System.out.println(min);
    }
}
