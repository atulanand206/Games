package com.games.CodeForces.multiply2Divide6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int n = inputInt(br);
            int twos = 0, threes = 0;
            while (n % 2 == 0) {
                twos++;
                n /= 2;
            }
            while (n % 3 == 0) {
                threes++;
                n /= 3;
            }
            if (n != 1 || threes < twos) {
                System.out.println(-1);
                continue;
            }
            System.out.println(2 * threes - twos);
        }
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
