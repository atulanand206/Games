package com.games.CodeForces.buyingTorches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            long x = Long.parseLong(spec[0]), y = Long.parseLong(spec[1]), k = Long.parseLong(spec[2]);
            if (x == 1) {
                System.out.println(-1);
                continue;
            }
            if (x > k + k * y) {
                long a = k + 1;
                System.out.println(a);
                continue;
            }
            long n = k + k * y - x;
            long d = x - 1;
            long p = (n / d) + k + 1;
            if (n % d != 0) p++;
            System.out.println(p);
        }
    }
}
