package com.games.CF.jss.saurabhArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        long a = Long.parseLong(spec[0]);
        long b = Long.parseLong(spec[1]);
        int i = 1, cnt = 0;
        while (a * i < b) {
            cnt++;
            i *= 2;
        }
        System.out.println(cnt);
    }
}
