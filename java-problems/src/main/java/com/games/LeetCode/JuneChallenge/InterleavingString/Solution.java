package com.games.LeetCode.JuneChallenge.InterleavingString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Solution().isInterleave(br.readLine(), br.readLine(), br.readLine()));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        if (s3.length() != s1.length() + s2.length()) return false;
        int x = 0, y = 0, z = 0;
        while(z < s3.length()) {
            System.out.println(z);
            if (x == s1.length() && y == s2.length()) break;
            if (x < s1.length() && s1.charAt(x) == s3.charAt(z)) {
                x++; z++; continue;
            }
            if (y < s2.length() && s2.charAt(y) == s3.charAt(z)) {
                y++; z++;
            }
        }
        return true;
    }
}
