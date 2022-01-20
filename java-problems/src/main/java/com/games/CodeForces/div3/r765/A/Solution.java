package com.games.CodeForces.div3.r765.A;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem: CodeForces 1625A
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(int[] x, int l) {
        int[] cnt = getSetBitsCount(x, l);
        int mid = getMid(cnt);
        return getClosest(cnt, mid);
    }

    private static int getClosest(int[] cnt, int mid) {
        int n = 0;
        for (int j : cnt) {
            if (j > mid) {
                n |= 1;
            }
            n <<= 1;
        }
        n >>= 1;
        return n;
    }

    private static int[] getSetBitsCount(int[] x, int l) {
        int[] cnt = new int[l];
        for (int i : x) {
            int z = i;
            int y = l - 1;
            while (z > 0) {
                if ((z & 1) == 1) cnt[y]++;
                z >>= 1;
                y--;
            }
        }
        return cnt;
    }

    private static int getMid(int[] cnt) {
        int max = 0;
        for (int i : cnt) max = Math.max(i, max);
        return (cnt.length - 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] y = inputLongArray(br);
            int[] x = inputLongArray(br);
            sb.append(solve(x, y[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
