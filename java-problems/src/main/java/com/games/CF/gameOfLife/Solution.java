package com.games.CF.gameOfLife;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], m = spec[1];
            char[] original = br.readLine().toCharArray();
            List<Integer> ones = new ArrayList<>();
            for (int i = 0; i < original.length; i++) if (original[i] == '1') ones.add(i);

            ListUtils.print(ones);
            List<Integer> zers = new ArrayList<>();
            if (ones.get(0) > m) { zers.add(0); zers.add(ones.get(0) - m - 1); }
            for (int i = 0; i < ones.size() - 1; i++) {
                int a = ones.get(i), b = ones.get(i+1);
                int aOff = a + m, bOff = b - m;
//                System.out.printf("%d %d %d %d ::::: \n", a, aOff, bOff, b);
                if ((b - a) % 2 == 0 && aOff - bOff >= 0) {
//                    System.out.println("S" + aOff);
                    int w = (a + b) / 2;
//                    System.out.println("TT" + w);
                    zers.add(w); zers.add(w);
                }
                else {
                    if (bOff - aOff >= 2) {
                        zers.add(aOff + 1);
                        zers.add(bOff - 1);
                    }
                }
            }
            if (ones.get(ones.size() - 1) + m < n) { zers.add(ones.get(ones.size() - 1) + m + 1); zers.add(n-1); }
            ListUtils.print(zers);


            StringBuilder sb = new StringBuilder();
            if (!zers.isEmpty() && zers.get(0) > 0)
                sb.append(new String(new char[zers.get(0) - 1]).replace("\0","0"));
//            System.out.println("-" + sb);
            int y = 0;
            while (y < zers.size()) {
                sb.append(new String(new char[zers.get(y+1) - zers.get(y)+1]).replace("\0","0"));
//                System.out.println("-" + sb);
                if (y < zers.size() - 2 && zers.get(y + 2) + 1 > zers.get(y + 1)) {
//                    System.out.println(zers.get(y + 2));
//                    System.out.println(zers.get(y + 2) - zers.get(y + 1) - 1);
                    sb.append(new String(new char[zers.get(y + 2) - zers.get(y + 1) - 1]).replace("\0", "1"));
                }
//                System.out.println("-" + sb);
//                System.out.println(":" + y);
                y += 2;
            }
            if (n - zers.get(zers.size() - 1) > 0)
                sb.append(new String(new char[n - zers.get(zers.size()-1)]).replace("\0", "0"));
            System.out.println(zers);
            System.out.println("-" + sb);
        }
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
