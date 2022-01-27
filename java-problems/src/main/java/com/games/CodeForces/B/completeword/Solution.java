package com.games.CodeForces.B.completeword;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 716B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(String str) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String game = alpha + "%" + str;
        int[] z = zArray(game, 0);
        for (int j : z)
            if (j == 26) {
                return alpha;
            }
        return String.valueOf(-1);
    }

    private static String hash(char[] str) {
        int[] res = new int[str.length - 26];
        int[] ques = new int[str.length - 26];
        int num = 0;
        for (int i = 0; i < 26; i++)
            if (str[i] != '?') num |= change(str[i]);
            else ques[0]++;
        int bits = cntBits(num);
        if (bits + ques[0] == 26) return fill(str, 0, 25);
        for (int i = 1; i < res.length; i++) {

        }
        return String.valueOf(res);
    }
    private static String fill(char[] str, int l, int r) {
        int[] arr = new int[26];
        for (int i = l; i <= r; i++) arr[(int) str[i] - 65] = 1;
        int j = 0;
        for (int i = l; i <= r; i++) {
            if (str[i] == '?') {
                while (arr[j] == 0) j++;
                str[i] = (char) (j + 65);
            }
        }
        return String.valueOf(str);
    }

    private static int change(char c) {
        return 1 << ((int) c - 65);
    }

    private static int cntBits(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num = num & (num - 1);
        }
        return cnt;
    }

    private static int[] zArray(String str, int exclude) {
        int[] z = new int[str.length()];
        z[0] = str.length();
        int start = 0, end = 0;
        for (int i = 1; i < str.length() - exclude; i++) {
            if (z[i - start] < end - i + 1) {
                z[i] = z[i - start];
            } else {
                int j = getJ(str, i, (i > end) ? i : end + 1);
                z[i] = j - i;
                start = i;
                end = j - 1;
            }
        }
        return z;
    }

    private static int getJ(String str, int of, int from) {
        int j = from;
        while (j < str.length() && (str.charAt(j) == str.charAt(j - of) || str.charAt(j) == '?')) j++;
        return j;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(br.readLine().trim()));
        }
        System.out.println(sb);
    }

    private static char[] inputCharArray(BufferedReader br) throws IOException {
        return br.readLine().trim().toCharArray();
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
