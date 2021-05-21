package com.games.CodeForces.metro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().split(" ");
        int n = Integer.parseInt(spec[0]), s = Integer.parseInt(spec[1]);
        String[] track1 = br.readLine().split(" ");
        String[] track2 = br.readLine().split(" ");
        if (!track1[0].equals("1")) {
            System.out.println("NO");
            return;
        }
        if (track1[s-1].equals("1")) {
            System.out.println("YES");
            return;
        }
        if (!track2[s-1].equals("1")) {
            System.out.println("NO");
            return;
        }
        for (int i= s; i<n;i++)
            if (track1[i].equals("1") && track2[i].equals("1")) {
                System.out.println("YES");
                return;
            }
        System.out.println("NO");
    }
}
