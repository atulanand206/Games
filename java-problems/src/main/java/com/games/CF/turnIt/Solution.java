package com.games.CF.turnIt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int u = Integer.parseInt(spec[0]);
            int v = Integer.parseInt(spec[1]);
            int a = Integer.parseInt(spec[2]);
            int s = Integer.parseInt(spec[3]);
            int val = u * u - 2 * a * s;
            if (val <= 0) {
                System.out.println("Yes");
                continue;
            }
            double vn = Math.sqrt(val);
            if (vn <= v) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
