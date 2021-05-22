package com.games.CF.codigo.lazyRavi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            String s = Long.toBinaryString(n);
            int cnt = 0;
            for (char ch : s.toCharArray()) if (ch == '1') cnt++;
            System.out.println(cnt);
        }
    }
}
