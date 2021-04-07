package com.games.CodeForces.expression;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int max = 1;
        max = Math.max(max, (a * b) + c);
        max = Math.max(max, a * (b + c));
        max = Math.max(max, a + (b * c));
        max = Math.max(max, (a + b) * c);
        max = Math.max(max, a * b * c);
        max = Math.max(max, a + b + c);
        System.out.println(max);
    }
}
