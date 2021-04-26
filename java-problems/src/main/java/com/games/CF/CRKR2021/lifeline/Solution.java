package com.games.CF.CRKR2021.lifeline;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), n = sc.nextInt(), d = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            int daysForChefToBeCured;
            if (a <= 18) daysForChefToBeCured = 10;
            else if (a <= 50) daysForChefToBeCured = 14;
            else daysForChefToBeCured = 21;
            boolean pos = false;
            if (x + y + z == n) {
                if (x != 0) if (d - 10 >= daysForChefToBeCured) pos = true;
                if (y != 0) if (d - 14 >= daysForChefToBeCured) pos = true;
                if (z != 0) if (d - 21 >= daysForChefToBeCured) pos = true;
            } else {
                pos = d >= daysForChefToBeCured;
            }
            System.out.println(pos ? "YES" : "NO");
        }
    }
}
