package com.games.CF.START3C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thiefAndPolice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] spec = br.readLine().split(" ");
            int n = Integer.parseInt(spec[0]), m = Integer.parseInt(spec[1]);
            spec = br.readLine().split(" ");
            int x = Integer.parseInt(spec[0]), y = Integer.parseInt(spec[1]);
            spec = br.readLine().split(" ");
            int a = Integer.parseInt(spec[0]), b = Integer.parseInt(spec[1]);
            int thief = n - x + m - y;
            int xp = n - a;
            int yp = m - b;
            int polic = Math.min(xp, yp) + Math.abs(xp - yp);
            boolean pos = polic < thief;
            System.out.println(pos ? "NO" : "YES");
        }
    }
}
