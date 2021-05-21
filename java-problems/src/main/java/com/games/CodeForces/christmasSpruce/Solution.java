package com.games.CodeForces.christmasSpruce;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] it = new int[n], deg = new int[n], leaves = new int[n];
        it[0] = -1;
        for (int i = 1; i < n; i++) {
            it[i] = sc.nextInt();
            it[i]--;
            deg[it[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0)
                leaves[it[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] >0 && leaves[i] < 3) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}