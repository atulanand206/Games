package com.games.CodeForces.bitmasks.maxmexcut;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem: CodeForces 1566C
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(String A) {
        int ans = (int) Arrays.stream(A.split("")).filter(x -> x.equals("0")).count();
        int n = A.length();
        boolean a = false, b = false;
        for (int i = 0; i < n; ++i) {
            if (A.charAt(i) == '0') a = true;
            if (A.charAt(i) == '1') b = true;
            if (a && b) {
                ++ans;
                a = b = false;
            }
        }
        return ans;
    }

    public static int solve(char[] A, char[] B) {
        StringBuilder s = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != B[i]) {
                ans += 2 + solve(s.toString());
                s = new StringBuilder();
            } else {
                s.append(A[i]);
            }
        }
        return ans + solve(s.toString());
    }

    private static int left(char[] A, char[] B) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i])
                cnt += 2;
            else {
                if (A[i] == '0') {
                    cnt++;
                }
                if (A[i] == '1') {
                    while (i + 1 < A.length && A[i + 1] == '1' && B[i + 1] == '1')
                        i++;
                    if (i + 1 < A.length && (A[i + 1] == '0' || B[i + 1] == '0')) {
                        cnt += 2;
                        i++;
                    }
                }
            }

        }
        return cnt;
    }

    private static int right(char[] A, char[] B) {
        int cnt = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] != B[i])
                cnt += 2;
            else {
                if (A[i] == '0') {
                    cnt++;
                }
                if (A[i] == '1') {
                    while (i - 1 >= 0 && A[i - 1] == '1' && B[i - 1] == '1')
                        i--;
                    if (i - 1 >= 0 && (A[i - 1] == '0' || B[i - 1] == '0')) {
                        cnt += 2;
                        i--;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            char[] a = br.readLine().trim().toCharArray();
            char[] b = br.readLine().trim().toCharArray();
            sb.append(solve(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
