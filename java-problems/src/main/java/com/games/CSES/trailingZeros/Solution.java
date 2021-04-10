package com.games.CSES.trailingZeros;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        long l = new Scanner(new InputStreamReader(System.in)).nextLong();
        long res = 0, k = 5;
        while (k <= l) { res += l / k; k = 5 * k; }
        System.out.println(res);
    }
}
