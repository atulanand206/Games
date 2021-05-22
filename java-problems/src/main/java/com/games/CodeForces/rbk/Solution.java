package com.games.CodeForces.rbk;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
        if (r1 == r2 || c1 == c2) System.out.printf("%d ", 1);
        else System.out.printf("%d ", 2);
        int rd = Math.abs(r1-r2);
        int cd = Math.abs(c1-c2);
        int d = Math.abs(rd - cd);
        if (d % 2 != 0) System.out.printf("%d ", 0);
        else if (d == 0) System.out.printf("%d ", 1);
        else System.out.printf("%d ", 2);
        int k = Math.min(rd, cd) + d;
        System.out.println(k);
    }
}
