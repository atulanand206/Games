package com.games.CSES.increasingArray;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        long n = sc.nextLong(), curr = sc.nextLong(), grow = 0;
        while (n-- > 1) {
            long ne = sc.nextLong();
            if (ne < curr) grow += curr - ne;
            curr = Math.max(curr, ne);
        }
        System.out.println(grow);
    }
}
