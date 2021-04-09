package com.games.CSES.weirdAlgorithm;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        long n = sc.nextLong();
        while (n != 1 && n > 0) {
            System.out.print(n + " ");
            if (n % 2 == 0) n = n / 2;
            else n = 3 * n + 1;
        }
        System.out.println(1);
    }
}
