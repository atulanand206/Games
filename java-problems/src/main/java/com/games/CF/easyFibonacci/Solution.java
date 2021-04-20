package com.games.CF.easyFibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        int[] fibo = new int[60];
        int a = 0, b = 1;
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < 60; i++) {
            int c = (a + b) % 10;
            fibo[i] = c;
            a = b;
            b = c;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            int k = 0;
            while (n > 0) {
                n /= 2;
                k++;
            }
            long m = (long) Math.pow(2, k - 1) - 1;
            sb.append(fibo[(int) (m % 60)]).append("\n");
        }

        System.out.println(sb);
    }
}
