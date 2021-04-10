package com.games.CSES.permutations;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        if (n == 1) System.out.println(1);
        else if (n < 4) System.out.println("NO SOLUTION");
        else if (n == 4) System.out.println("2 4 1 3");
        else {
            StringBuilder sb = new StringBuilder();
            if (n % 2 == 0) {
                for (int i = 1; i <= n - 1; i += 2) sb.append(i).append(" ");
                sb.append(n - 4).append(" ");
                for (int i = n; i >= 2; i -= 2) if (i != n - 4) sb.append(i).append(" ");
            } else {
                for (int i = 1; i <= n; i += 2) sb.append(i).append(" ");
                sb.append(n - 3).append(" ");
                for (int i = n - 1; i >= 2; i -= 2) if (i != n - 3) sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }
}
