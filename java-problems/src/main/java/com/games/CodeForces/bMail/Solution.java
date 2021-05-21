package com.games.CodeForces.bMail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] it = new int[n];
        it[0] = -1;
        for (int i = 1; i < n; i++) {
            it[i] = sc.nextInt();
            it[i]--;
        }
        List<Integer> path = new ArrayList<>();
        int p = n - 1;
        while (it[p] != -1) {
            path.add(p + 1);
            p = it[p];
        }
        path.add(1);
        Collections.reverse(path);
        print(path);
    }

    public static <T> void print(List<T> list) {
        for (T in : list)
            System.out.print(in + " ");
        System.out.println();
    }

}

