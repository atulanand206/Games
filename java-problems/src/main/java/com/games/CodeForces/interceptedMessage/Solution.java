package com.games.CodeForces.interceptedMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spec = br.readLine().trim().split(" ");
        int n1 = Integer.parseInt(spec[0]);
        int n2 = Integer.parseInt(spec[1]);
        int[] s1 = intArray(br.readLine().split(" "));
        int[] s2 = intArray(br.readLine().split(" "));
        int c1 = 0, c2 = 0, x1 = 0, x2 = 0, res = 0;
        while (x1 < n1 && x2 < n2) {
            if (c1 + s1[x1] < c2 + s2[x2]) c1 += s1[x1++];
            else if (c1 + s1[x1] > c2 + s2[x2]) c2 += s2[x2++];
            else {
                c1 += s1[x1++];
                c2 += s2[x2++];
                res++;
            }
//            System.out.printf("%d : %d : %d : %d : %d\n", c1, x1, c2, x2, res);
        }
        System.out.println(res);
    }

    private static int[] intArray(String[] list) {
        int[] integers = new int[list.length];
        for (int i = 0; i < list.length; i++) integers[i] = Integer.parseInt(list[i]);
        return integers;
    }
}
