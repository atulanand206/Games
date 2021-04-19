package com.games.CF.giftOfLove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(new InputStreamReader(System.in));
        int t = br.nextInt();
        while (t-- > 0) {
            int x = br.nextInt();
            int b = br.nextInt();
            long[][] dishes = new long[b][2];
            for (int i = 0; i < b; i++) {
                dishes[i][0] = br.nextLong();
                dishes[i][1] = br.nextLong();
            }
            int c = br.nextInt();
            long[][] clans = new long[c][3];
            for (int i = 0; i < c; i++) {
                clans[i][0] = br.nextLong();
                clans[i][1] = br.nextLong();
                clans[i][2] = br.nextLong();
            }
            System.out.println(requiredMen(dishes, clans));
        }
    }

    private static int requiredMen(long[][] dishes, long[][] clans) {
        int men = 1;
        for (long[] dish : dishes)
            men += dish[1];
        if (clans.length != 0) {
            int s = 1, e = men;
            while (s <= e) {
                int m = (s + e) / 2;
                int v = fn(dishes, clans, m);
                if (v > 0) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
            men = s;
        }
        return men;
    }

    private static int fn(long[][] ds, long[][] cs, int m) {
        int di = 0, ci = 0;
        while (di < ds.length && ci < cs.length) {
            if (ds[di][0] < cs[ci][0]) {
                m -= ds[di][1];
                di++;
            } else if (ds[di][0] > cs[ci][0]) {
                if (m >= cs[ci][1])
                    m += cs[ci][2];
                ci++;
            } else {
                if (m >= cs[ci][1])
                    m += cs[ci][2];
                m -= ds[di][1];
                di++;
                ci++;
            }
        }
        while (di < ds.length) {
            m -= ds[di][1];
            di++;
        }
        return m;
    }
}
