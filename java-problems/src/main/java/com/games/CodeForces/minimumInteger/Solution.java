package com.games.CodeForces.minimumInteger;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int t = sc.nextInt();
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int d = sc.nextInt();
            int ans = d;
            if (d >= l && d <= r) {
                int next = (int) (Math.floor((double) r / d) + 1);
                ans = next * d;
            }
            System.out.println(ans);
        }
    }
}
