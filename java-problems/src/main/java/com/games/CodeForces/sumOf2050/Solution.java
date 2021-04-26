package com.games.CodeForces.sumOf2050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            long n = inputLong(br);
            if (n % 2050 != 0) {
                System.out.println(-1);
                continue;
            }
            n = n / 2050;
            int x = 0;
            while (n > 0) {
                x += n % 10;
                n /= 10;
            }
            System.out.println(x);
        }
    }

    private static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine());
    }
}

