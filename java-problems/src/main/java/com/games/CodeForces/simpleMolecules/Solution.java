package com.games.CodeForces.simpleMolecules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int x = Integer.parseInt(spec[0]);
        int y = Integer.parseInt(spec[1]);
        int z = Integer.parseInt(spec[2]);
        int k = (x + y + z);
        if (k % 2 != 0) {
            System.out.println("Impossible");
            return;
        }
        k = k / 2;
        int a = k - x;
        int b = k - y;
        int c = k - z;
        if (a < 0 || b < 0 || c < 0) {
            System.out.println("Impossible");
            return;
        }
        if ((a == 0 && b == 0 && c > 0)
                || (b == 0 && a > 0 && c == 0)
                || (a == 0 && c == 0 && b > 0)
                || (a == 0 && b == 0 && c == 0)) System.out.println("Impossible");
        else System.out.printf("%d %d %d\n", c, a, b);
    }
}
