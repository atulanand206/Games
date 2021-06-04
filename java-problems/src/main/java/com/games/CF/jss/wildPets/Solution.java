package com.games.CF.jss.wildPets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final int MOD = (int) (10E9 + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int a = Integer.parseInt(spec[0]);
        int b = Integer.parseInt(spec[1]);
        long ans = 0;
        long k = (fact(a) * fact(b)) % MOD;
        if (a == b) ans = (k * 2) % MOD;
        else if (Math.abs(a - b) == 1) ans = k;
        System.out.println(ans);
    }

    private static long fact(int a) {
        long f = 1;
        for (int i = 1; i <= a; i++) {
            f = (f * i) % MOD;
        }
        return f;
    }
}
