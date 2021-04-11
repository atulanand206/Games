package com.games.CF.pumpTheWaterOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int st = 0, tot = 0;
        int[] data = intArray(sc.readLine());
        int s = 1, l = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) tot++;
            if (i > 0 && data[i - 1] == 0 && data[i] != 0) {
                st += Math.min(s, data[i]) * (i - l);
            }
            if (i < data.length - 1 && data[i] != 0 && data[i + 1] == 0) {
                s = data[i];
                l = i + 1;
            }
        }
        System.out.println(tot + " " + st);
    }

    private static int[] intArray(String num) {
        String[] chars = num.split(" ");
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++)
            ints[i] = Integer.parseInt(chars[i]);
        return ints;
    }
}
