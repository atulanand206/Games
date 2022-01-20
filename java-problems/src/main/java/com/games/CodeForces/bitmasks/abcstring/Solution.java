package com.games.CodeForces.bitmasks.abcstring;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem: CodeForces 1494A
 *
 * @author atulanand
 */
public class Solution {

    public static boolean solve(char[] A) {
        int len = A.length;
        if (A[0] == A[len - 1]) return false;
        char open = A[0];
        char close = A[len - 1];
        for (int i = 0; i < len; i++) {
            if (A[i] == open) A[i] = '(';
            if (A[i] == close) A[i] = ')';
        }
        char[] pos1 = new char[len];
        char[] pos2 = new char[len];
        for (int i = 0; i < len; i++) {
            if (A[i] == '(' || A[i] == ')') {
                pos1[i] = A[i];
                pos2[i] = A[i];
            } else {
                pos1[i] = '(';
                pos2[i] = ')';
            }
        }
        int c1 = 0;
        for (char ch : pos1)
            c1 += (ch == '(') ? 1 : -1;
        int c2 = 0;
        for (char ch : pos2)
            c2 += (ch == '(') ? 1 : -1;
        return checkRegular(pos1) || checkRegular(pos2);
    }

    private static boolean checkRegular(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                char ch1 = stack.pop();
                if (ch1 == ')')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(br.readLine().trim().toCharArray()) ? "YES" : "NO").append("\n");
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
