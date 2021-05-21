package com.games.CodeForces.party;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] it = new int[n + 1];
        it[0] = -1;
        for (int i = 1; i <= n; i++) {
            it[i] = sc.nextInt();
            if (it[i] == -1) it[i] = 0;
        }
        System.out.println(findHeight(it) - 1);
    }

    static int findHeight(int[] parent) {
        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            int p = i, current = 1;
            while (parent[p] != -1) {
                current++;
                p = parent[p];
            }
            res = Math.max(res, current);
        }
        return res;
    }
}
