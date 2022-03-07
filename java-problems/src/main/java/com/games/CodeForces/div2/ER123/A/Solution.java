package com.games.CodeForces.div2.ER123.A;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.LongStream;

/**
 * Problem: CodeForces 1644A
 *
 * @author atulanand
 */
public class Solution {

    public static boolean solve(char[] arr) {
        boolean red = false, green = false, blue = false;
        for (char ch : arr) {
            if (ch == 'r') {
                red = true;
            } else if (ch == 'R') {
                if (!red) {
                    return false;
                }
            } else if (ch == 'g') {
                green = true;
            } else if (ch == 'G') {
                if (!green) {
                    return false;
                }
            } else if (ch == 'b') {
                blue = true;
            } else if (ch == 'B') {
                if (!blue) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve(br.readLine().toCharArray()) ? "YES" : "NO").append("\n");
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
