package com.games.CodeForces.luckyDivision;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isAlmostLucky(new Scanner(new InputStreamReader(System.in)).nextInt()) ? "YES" : "NO");
    }

    private static boolean isAlmostLucky(int x) {
        int[] lucky = new int[]{4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777};
        for (int l : lucky) if (x % l == 0) return true;
        return false;
    }
}
