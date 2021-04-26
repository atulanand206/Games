package com.games.CF.CRKR2021.switchGame;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = 1;
            while (k * k <= n) {
                System.out.printf("%d ", k * k);
                k++;
            }
        }
    }
}
