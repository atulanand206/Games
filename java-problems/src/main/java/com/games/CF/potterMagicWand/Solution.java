package com.games.CF.potterMagicWand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] specs = br.readLine().split(" ");
            long a = at(specs, 0), b = at(specs, 1);
            System.out.println(a | b);
        }
    }

    private static long at(String[] ar, int index) {
        return Long.parseLong(ar[index]);
    }
}
