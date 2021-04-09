package com.games.CSES.repetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s = sc.readLine().trim();
        if (s.length() == 1)
            System.out.println(1);
        else {
            int count = 1, maxCount = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) count++;
                else count = 1;
                maxCount = Math.max(count, maxCount);
            }
            System.out.println(maxCount);
        }
    }
}
