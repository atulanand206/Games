package com.games.CSES.numberSpiral;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        long t = sc.nextLong();
        long y, x;
        while (t-- > 0) {
            y = sc.nextLong();
            x = sc.nextLong();
            if (x == 1 && y == 1) {
                System.out.println(1);
                continue;
            }
        }
    }
}
