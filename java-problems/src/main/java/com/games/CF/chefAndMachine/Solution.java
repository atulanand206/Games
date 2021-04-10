package com.games.CF.chefAndMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        long[] ar = new long[21];
        ar[0] = 1;
        for (int i = 1; i <= 20; i++) ar[i] = i * ar[i - 1];
        while (t-- > 0) System.out.println(ar[Integer.parseInt(br.readLine().trim())]);
    }
}
