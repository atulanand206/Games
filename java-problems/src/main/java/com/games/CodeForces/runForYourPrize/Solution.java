package com.games.CodeForces.runForYourPrize;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int maxYou = 1;
        int limit = (int) Math.pow(10, 6);
        int maxFrn = limit;
        int mid = maxFrn / 2;
        while (n-- > 0) {
            int k = sc.nextInt();
            if (k <= mid) {
                maxYou = Math.max(maxYou, k);
            }
            if (k > mid) {
                maxFrn = Math.min(maxFrn, k);
            }
        }
        System.out.println(Math.max(maxYou - 1, limit - maxFrn));
    }
}
