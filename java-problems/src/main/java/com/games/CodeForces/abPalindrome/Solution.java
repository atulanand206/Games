package com.games.CodeForces.abPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] specs = br.readLine().split(" ");
            int a = at(specs, 0), b = at(specs, 1);
            char[] s = br.readLine().toCharArray();
            for (char ch : s) {
                if (ch == '1') b--;
                else if (ch == '0') a--;
            }
            List<Integer> ques = new ArrayList<>();
            for (int i = 0; i < s.length / 2; i++) {
                int rx = s.length - 1 - i;
                char left = s[i];
                char right = s[rx];
                if (left == '1' && right == '?') {
                    s[rx] = '1';
                    b--;
                } else if (left == '?' && right == '1') {
                    s[i] = '1';
                    b--;
                } else if (left == '0' && right == '?') {
                    s[rx] = '0';
                    a--;
                } else if (left == '?' && right == '0') {
                    s[i] = '0';
                    a--;
                } else if (left == '?' && right == '?') {
                    ques.add(i);
                }
            }
            if (a < 0 || b < 0) {
                System.out.println(-1);
                continue;
            }
            for (int i : ques) {
                int rx = s.length - 1 - i;
                if (a >= 2) {
                    s[i] = '0';
                    s[rx] = '0';
                    a -= 2;
                } else if (b >= 2) {
                    s[i] = '1';
                    s[rx] = '1';
                    b -= 2;
                }
            }
            if (a < 0 || b < 0) {
                System.out.println(-1);
                continue;
            }
            if (s.length % 2 != 0) {
                if (a == 1) {
                    s[s.length / 2] = '0';
                    a--;
                } else if (b == 1) {
                    s[s.length / 2] = '1';
                    b--;
                }
            }
            if (a < 0 || b < 0) {
                System.out.println(-1);
                continue;
            }
            boolean invalid = false;
            StringBuilder sb = new StringBuilder();
            for (char ch : s) {
                if (ch == '?') {
                    invalid = true;
                    break;
                }
                sb.append(ch);
            }
            for (int i = 0; i < s.length / 2; i++) {
                int rx = s.length - 1 - i;
                if (s[i] != s[rx]) {
                    invalid = true;
                    break;
                }
            }
            if (invalid)
                System.out.println(-1);
            else
                System.out.println(sb);
        }
    }

    private static int at(String[] ar, int index) {
        return Integer.parseInt(ar[index]);
    }

}
