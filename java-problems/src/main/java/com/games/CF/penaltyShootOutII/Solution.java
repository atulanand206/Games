package com.games.CF.penaltyShootOutII;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean f = false;
            int N = Integer.parseInt(br.readLine());
            String conf = br.readLine();
            int a = 0, b = 0;
            int[] ar = new int[2 * N];
            for (int i = 0; i < conf.length(); i++) {
                if (conf.charAt(i) == '1') if (i % 2 == 0) a++;
                else b++;
                ar[i] = (i % 2 == 0) ? a : b;
            }
            for (int i = 1; i < conf.length(); i++) {
                int diff = ar[i] - ar[i - 1];
                int shotsPlayed = i + 1;
                if (diff < 0) {
                    int shotsLeft = (conf.length() - shotsPlayed) / 2;
                    if (-1 * diff > shotsLeft) {
                        System.out.println(shotsPlayed);
                        f = true;
                        break;
                    }
                } else {
                    int shotsLeft = (conf.length() - i) / 2;
                    if (diff > shotsLeft) {
                        System.out.println(shotsPlayed);
                        f = true;
                        break;
                    }
                }

            }
            if (!f && a == b) System.out.println(conf.length());
        }
    }
}
