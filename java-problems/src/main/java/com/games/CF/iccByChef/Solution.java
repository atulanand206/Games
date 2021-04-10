package com.games.CF.iccByChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            char[] config = br.readLine().trim().toCharArray();
            int max = 0;
            char ite = 'P';
            if (config.length == 1) {
                System.out.println(1);
                continue;
            }
            int count = 1;
            for (int i = 1; i < config.length; i++) {
                if (config[i] == config[i - 1]) count++;
                else count = 1;
                if (count > max) {
                    max = Math.max(count, max);
                    ite = config[i];
                }
            }
            System.out.println(max + " " + ite);
        }
    }
}
