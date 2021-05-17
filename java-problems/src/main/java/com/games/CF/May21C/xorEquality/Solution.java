package com.games.CF.May21C.xorEquality;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final long MOD = (long) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int n = inputInt(br);
            if (n == 1) System.out.println(1);
            else {
                n--;
                long a = 2;
                long ans = 1;
                while (n > 0) {
                    if ((n & 1) == 1) ans = (ans * a) % MOD;
                    a = (a * a) % MOD;
                    n >>= 1;
                }
                System.out.println(ans);
            }
        }
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
