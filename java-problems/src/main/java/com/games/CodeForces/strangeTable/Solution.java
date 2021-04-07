package com.games.CodeForces.strangeTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] ns = br.readLine().split(" ");
            int n = Integer.parseInt(ns[0]);
            int m = Integer.parseInt(ns[1]);
            long x = Long.parseLong(ns[2]);
            System.out.println(new Solution().rowsFromColumns(n, m, x));
        }
    }

    public long rowsFromColumns(int n, int m, long x) {
        long i = x / n;
        long j = x % n;
        if (j == 0) {
            i--;
            j = n - 1;
        } else
            j--;
        return (i + 1) + m * j;
    }
}
