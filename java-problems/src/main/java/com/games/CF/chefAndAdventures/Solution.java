package com.games.CF.chefAndAdventures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]);
            int m = Integer.parseInt(spec[1]);
            int x = Integer.parseInt(spec[2]);
            int y = Integer.parseInt(spec[3]);
            boolean pos = (n - 1 >=  0 && m - 1 >= 0 && (n - 1) % x == 0 && (m - 1) % y == 0)
                    || (n - 2 >= 0 && m - 2 >= 0 && (n - 2) % x == 0 && (m - 2) % y == 0);
            System.out.println(pos ? "Chefirnemo" : "Pofik");
        }
    }
}
