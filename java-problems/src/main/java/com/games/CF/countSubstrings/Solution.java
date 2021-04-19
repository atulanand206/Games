package com.games.CF.countSubstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]);
            int k = Integer.parseInt(spec[1]);
            int q = Integer.parseInt(spec[2]);
            String s = br.readLine();

            int[] c0 = new int[n + 1];
            int[] c1 = new int[n + 1];
            if (s.charAt(0) == '0') c0[1]++;
            else c1[1]++;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == '0') {
                    c0[i + 1] = c0[i] + 1;
                    c1[i + 1] = c1[i];
                } else {
                    c0[i + 1] = c0[i];
                    c1[i + 1] = c1[i] + 1;
                }
            }

            int[] pos = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int st = i;
                int e = n;
                int j = 0;
                while (st <= e) {
                    int m = (st + e) / 2;
                    if (c0[m] - c0[i - 1] <= k && c1[m] - c1[i - 1] <= k) {
                        j = m;
                        st = m + 1;
                    } else {
                        e = m - 1;
                    }
                }
                pos[i] = j;
            }

            long[] dp = new long[n + 1];
            for (int i = 1; i <= n; i++) dp[i] = dp[i - 1] + pos[i] - i + 1;

            while (q-- > 0) {
                String[] ispec = br.readLine().split(" ");
                int l = Integer.parseInt(ispec[0]);
                int r = Integer.parseInt(ispec[1]);
                int st = l, e = r, v = l - 1;
                while (st <= e) {
                    int m = (st + e) / 2;
                    if (pos[m] < r) {
                        v = m;
                        st = m + 1;
                    } else {
                        e = m - 1;
                    }
                }
                long cnt = dp[v] - dp[l - 1] + (long) (r - v) * (r - v + 1) / 2;
                sb.append(cnt).append("\n");
            }
        }
        System.out.println(sb);
    }
}
