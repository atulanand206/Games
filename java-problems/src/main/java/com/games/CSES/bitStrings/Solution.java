package com.games.CSES.bitStrings;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        long x = sc.nextInt(), res = 1, limit = (long) (Math.pow(10, 9) + 7);
        while (x-- > 0) res = (res * 2) % limit;
        System.out.println(res);
    }
}
