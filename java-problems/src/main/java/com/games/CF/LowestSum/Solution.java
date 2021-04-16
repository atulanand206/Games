package com.games.CF.LowestSum;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int size = 200;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int k = Integer.parseInt(spec[0]);
            int q = Integer.parseInt(spec[1]);
            String[] ass = br.readLine().split(" ");
            long[] as = new long[k];
            for (int i = 0; i < ass.length; i++) as[i] = Long.parseLong(ass[i]);
            String[] bss = br.readLine().split(" ");
            long[] bs = new long[k];
            for (int i = 0; i < bss.length; i++) bs[i] = Long.parseLong(bss[i]);
            int e = 0, f = 0;
            if (k > size) {
                Arrays.sort(as);
                Arrays.sort(bs);
                while (e*f <= size*size ) {
                    if (e == k) {
                        f++;
                    } else if (f == k) {
                        e++;
                    } else if (as[e] < bs[f]) {
                        e++;
                    } else {
                        f++;
                    }
                }
            } else {
                e = k;
                f = k;
            }
            long[] ns = new long[e * f];
            int h = 0;
            for (int i = 0; i < e; i++)
                for (int j = 0; j < f; j++)
                    ns[h++] = (as[i] + bs[j]);
            Arrays.sort(ns);
            while (q-- > 0) {
                int m = Integer.parseInt(br.readLine());
                sb.append(ns[(m - 1)]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
