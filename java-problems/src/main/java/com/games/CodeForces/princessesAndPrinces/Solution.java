package com.games.CodeForces.princessesAndPrinces;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] marriedPrinces = new boolean[n];
            boolean[] marriedPrincesses = new boolean[n];
            for (int i = 0; i < n; i++) {
                int pc = sc.nextInt();
                if (pc > 0) {
                    List<Integer> prcs = new ArrayList<>();
                    while (pc-- > 0) {
                        int e = sc.nextInt();
                        if (!marriedPrinces[e - 1])
                            prcs.add(e - 1);
                    }
                    Collections.sort(prcs);
                    if (!prcs.isEmpty()) {
                        marriedPrinces[prcs.get(0)] = true;
                        marriedPrincesses[i] = true;
                    }
                }
            }
            int princeLeft = -1, princessLeft = -1;
            for (int i = 0; i < n; i++)
                if (!marriedPrinces[i]) {
                    princeLeft = i;
                    break;
                }
            for (int i = 0; i < n; i++)
                if (!marriedPrincesses[i]) {
                    princessLeft = i;
                    break;
                }
            if (princeLeft != -1 && princessLeft != -1)
                System.out.printf("IMPROVE\n%d %d\n", princessLeft + 1, princeLeft + 1);
            else
                System.out.println("OPTIMAL");
        }
    }
}
