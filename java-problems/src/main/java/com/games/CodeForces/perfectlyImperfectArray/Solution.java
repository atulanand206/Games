package com.games.CodeForces.perfectlyImperfectArray;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        Set<Integer> set = perfectSquares(10000);
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean pos = false;
            while (n-- > 0) {
                int x = sc.nextInt();
                if (!set.contains(x)) pos = true;
            }
            System.out.println(pos ? "YES" : "NO");
        }
    }

    private static Set<Integer> perfectSquares(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) set.add(i * i);
        return set;
    }
}
