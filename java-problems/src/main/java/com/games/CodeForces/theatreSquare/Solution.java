package com.games.CodeForces.theatreSquare;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(new InputStreamReader(System.in));
        long n = s.nextLong(), m = s.nextLong(), a = s.nextLong();
        long res = 1;
        if (n % a != 0) res *= (n + a) / a; else res *= n/a;
        if (m % a != 0) res *= (m + a) / a; else res *= m/a;
        System.out.println(res);
    }
}
