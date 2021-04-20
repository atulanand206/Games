package com.games.CF.IARCS.leadGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int as = 0, bs = 0;
        List<Integer> l = new ArrayList<>();
        while (n-- > 0) {
            String[] spec = br.readLine().split(" ");
            int a = Integer.parseInt(spec[0]);
            int b = Integer.parseInt(spec[1]);
            as += a;
            bs += b;
            l.add(as - bs);
        }
        int b = Collections.min(l), a = Collections.max(l);
        if (b >= 0) System.out.printf("1 %d", a);
        else if (a <= 0) System.out.printf("2 %d", b * -1);
        else System.out.print((a > -b ? 1 : 2) + " " + Math.max(a, -b));
    }
}
