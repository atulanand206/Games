package com.games.CodeForces.loveTriangle;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] is = br.readLine().split(" ");
        int[] it = new int[n];
        for (int i = 0; i < n; i++) it[i] = Integer.parseInt(is[i]) - 1;
        for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];
            int p = i, cnt = 0;
            while (cnt <= 3) {
                if (cnt == 3) {
                    if (p == i) {
                        System.out.println("YES");
                        return;
                    } else break;
                }
                if (v[p]) break;
                v[p] = true;
                p = it[p];
                cnt++;
            }
        }
        System.out.println("NO");
    }
}
