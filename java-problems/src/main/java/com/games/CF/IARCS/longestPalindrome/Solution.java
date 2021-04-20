package com.games.CF.IARCS.longestPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder sub = new StringBuilder();
            for (int j = i; j < n; j++) {
                sub.append(s.charAt(j));
                if (isPalindrome(sub.toString()) && sub.length() > answer.length())
                    answer = new StringBuilder(sub);
            }
        }
        System.out.println(answer.length());
        System.out.println(answer);
    }

    private static boolean isPalindrome(String st) {
        for (int i = 0; i < st.length() / 2; i++)
            if (st.charAt(i) != st.charAt(st.length() - i - 1))
                return false;
        return true;
    }
}
