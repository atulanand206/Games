package com.games.CodeForces.A.closingthegap;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem: CodeForces 1615A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] A) {
        int diff = Integer.MAX_VALUE;
        while (A[A.length - 1] - A[0] < diff) {
            Arrays.sort(A);
            int sum = A[A.length - 1] + A[0];
            diff = A[A.length - 1] - A[0];
            int one = sum / 2;
            int next = sum - one;
            A[0] = one;
            A[A.length - 1] = next;
        }
        Arrays.sort(A);
        return A[A.length - 1] - A[0];
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputInt(br);
            sb.append(solve(inputIntArray(br))).append("\n");
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
