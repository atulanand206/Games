package com.games.CF.codigo.substring;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        char x = sc.next().toCharArray()[0];
        int[] ar = new int[s.length];
        int y = sc.nextInt();
        for (int i = 0; i < s.length; i++)
            if (s[i] == x) ar[i] = 1;
            else ar[i] = 0;
        System.out.println(subString(ar, ar.length, y));
    }

    static int subString(int[] str, int n, int y) {
        int mn = 0;
        // Pick starting point
        for (int len = 1; len <= n; len++) {
            // Pick ending point
            for (int i = 0; i <= n - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                int cnt = 0;
                for (int k = i; k <= j; k++) {
                    if (str[k] == 1) cnt++;
                }
                if (cnt == y) mn++;
            }
        }
        return mn;
    }
}
