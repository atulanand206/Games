package com.games.CF.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if (b == 0) {
                System.out.println(0);
                continue;
            }
            double v = (a / ((double) b));
            v = v % 1;
            String s1 = String.valueOf(v);
            s1 = s1.substring(2);
            String[] str = s1.split("");
            long count = 0;
            for (int i = 0; i < k && i < s1.length(); i++) count += Integer.parseInt(str[i]);
            System.out.println(count);
        }
    }
}
