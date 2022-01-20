package com.games.CodeForces.oddgrashoppers;

import static com.games.utils.I.*;
import static com.games.utils.O.*;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * Problem: CodeForces 1607B
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long initialPosition, long jumpCount) {
        long currentPosition = initialPosition;
//        int x = spot(initialPosition, jumpCount);
        for (int i = 1; i <= jumpCount; i++) {
            long difference = i;
            int side = isEven(currentPosition) ? -1 : 1;
            currentPosition += side * difference;
            debug(String.format("%4d %4d", currentPosition, spot(initialPosition, i)));
            if (i % 4 == 0) debugNewLine();
        }
        return currentPosition;
    }

    private static boolean isEven(long x) {
        return (x & 1) == 0;
    }

    private static long spot(long initialPosition, long jumpCount) {
        switch ((int) (jumpCount % 2)) {
            case 0:
                switch ((int) (jumpCount % 4)) {
                    case 1:
                        return initialPosition + (initialPosition % 2 == 0 ? -1 : 1) * jumpCount;
                    case 2:
                        return initialPosition + (initialPosition % 2 == 0 ? 1 : -1);
                    case 3:
                        return 1 + (initialPosition % 2 == 0 ? 1 : -1) * (jumpCount + initialPosition);
                    case 0:
                        return initialPosition;
                }
            case 1:
                switch ((int) (jumpCount % 4)) {
                    case 1:
                        return initialPosition + (initialPosition % 2 == 0 ? -1 : 1) * jumpCount;
                    case 2:
                        return initialPosition + (initialPosition % 2 == 0 ? 0 : 1);
                    case 3:
                        return initialPosition + (initialPosition % 2 == 0 ? 1 : -1) * (jumpCount + 1);
                    case 0:
                        return initialPosition + (initialPosition % 2 == 0 ? 1 : 0);
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        attach();
        BufferedReader br = new BufferedReader(reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long[] x = inputLongArray(br);
            sb.append(solve(x[0], x[1])).append(" ").append(spot(x[0], x[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long inputLong(BufferedReader br) throws IOException {
        return Long.parseLong(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        return getInts(spec);
    }

    private static long[] getInts(String[] spec) {
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
