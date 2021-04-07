package com.games.CodeForces.stonesOnTheTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        sc.readLine();
        int c = 0;
        String s = sc.readLine();
        if (s.length() > 1) for (int i = 1; i < s.length(); i++) if (s.charAt(i) == s.charAt(i - 1)) c++;
        System.out.println(c);
    }
}

