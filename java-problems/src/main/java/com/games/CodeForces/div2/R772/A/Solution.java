package com.games.CodeForces.div2.R772.A;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1635A
 *
 * @author atulanand
 */
public class Solution {

    public static int solve(int[] a) {
        int[] bits = new int[32];
        for (int i : a) {
            int k = i;
            int j = 0;
            while (k > 0) {
                bits[j] += ((1 & k) == 1) ? 1 : 0;
                k >>= 1;
                j++;
            }
        }
        int sum = 0, x = 1;
        for (int bit : bits) {
            if (bit >= 1) {
                sum += x;
            }
            x *= 2;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int y = inputInt(br);
            int[] a = inputIntArray(br);
            sb.append(solve(a)).append("\n");
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
