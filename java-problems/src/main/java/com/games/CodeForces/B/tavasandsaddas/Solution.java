package com.games.CodeForces.B.tavasandsaddas;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 535B
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(int A) {
        int len = cntDigits(A);
        int bin = 0;
        int i = 0;
        while (A > 0) {
            if (A % 10 == 7) bin |= (1 << i);
            i++;
            A /= 10;
        }
        int res = getPrev(len - 1) + bin + 1;
        return String.valueOf(res);
    }

    private static int getPrev(int len) {
        int x = 2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += x;
            x *= 2;
        }
        return sum;
    }

    private static int cntDigits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(inputInt(br)));
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
