package com.games.CodeChef.jan221b.chefandrifles;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeChef Long Challenge
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int n, int k) {
        int[] res = new int[n];
        if (isPowerOfTwo(n)) {
            res = transformPowerOf2(n, k);
        } else {
            for (int i = 0; i < res.length; i++) res[i] = i + 1;
            int p = period(n);
            int times = k % p;
            O.debug(S.string(p));
            O.debug(S.string(times));
            res = transformNotPowerOf2(n, times);
        }
        return getString(res);
    }

    private static int period(int n) {
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) res[i] = i + 1;
        int p = 0;
        O.debug(S.string(res));
        while (true) {
            res = transform(res);
            p++;
            if (res[1] == 2) break;
            O.debug(S.string(res));
        }
        return p;
    }

    private static int[] transform(int[] res) {
        int[] md = new int[res.length];
        int i = 0, j = 0;
        while (i < md.length && j < res.length) {
            md[i] = res[j];
            i++;
            j += 2;
        }
        j = 1;
        while (i < md.length && j < res.length) {
            md[i] = res[j];
            i++;
            j += 2;
        }
        return md;
    }

    private static int[] transformNotPowerOf2(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) res[i] = i + 1;
        int[] ans = new int[n];
        int z = 0, i = 0;
        while (i + 1 < res.length) {
            ans[i++] = res[z];
            z = (z + k + 1) % (n - 1);
        }
        ans[n - 1] = n;
        return ans;
    }

    private static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    private static int[] transformPowerOf2(int n, int k) {
        int[] res = new int[n];
        int z = 1, i = 0, curr = 1;
        int diff = Integer.toBinaryString(n).length() - 1;
        int times = (int) Math.pow(2, k % diff);
        while (i < res.length) {
            res[i++] = curr;
            if (curr + times <= n) {
                curr += times;
            } else {
                curr = ++z;
            }
        }
        return res;
    }

    private static String getString(int[] res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
            if (i + 1 < res.length) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
//        O.debug(S.string(transform(14, 5)));
//        for (int i = 2; i < 100; i+=2) {
//            if ((i & (i - 1)) == 0) continue;
//            O.debug(i + " " + period(i) + "\n");
//        }
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] x = inputIntArray(br);
            sb.append(solve(x[0], x[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        return getInts(spec);
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    private static int[] getInts(String[] spec) {
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
