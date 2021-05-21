package com.games.CodeForces.boardMoves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int k = n / 2;
            long res = 0;
            long val = 1;
            for (int i = 1; i <= k; i++) {
                res += val;
                val = val + 2L * i + 1;
            }
            System.out.println(8 * res);
        }
    }
}
