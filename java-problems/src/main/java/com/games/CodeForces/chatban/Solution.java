package com.games.CodeForces.chatban;

import com.games.utils.I;
import com.games.utils.O;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 1612C
 *
 * @author atulanand
 */
public class Solution {

    private static class Quadratic {
        double a;
        double b;
        double c;

        public Quadratic(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double determinant() {
            double dS = b * b - 4 * this.a * c;
            if (dS < 0) return -1;
            return Math.sqrt(dS);
        }

        double[] roots() {
            double d = determinant();
            if (d == -1) return new double[]{};
            return new double[]{(-b - d) / 2, (-b + d) / 2};
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();

        BufferedReader br = new BufferedReader(I.reader(true));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long[] q = inputLongArray(br);
//            O.debug(S.string(q));
            long k = q[0], x = q[1], ans = 0;
            if (maxMessages(k) <= x) {
                sb.append(2 * k - 1).append("\n");
                continue;
            }
            long lines = 0;

            long topTriangle = topRows(k, x);
            long xInTopTriangle = sumN(topTriangle);
            lines += topTriangle;

            long xForBottomTriangle = x - xInTopTriangle;
            if (topTriangle < k) {
                if (xForBottomTriangle > 0 && xForBottomTriangle < topTriangle) {
                    lines++;
                    sb.append(lines).append("\n");
                    continue;
                }
            }

            if (xForBottomTriangle > 0) {
                long bottomTriangle = bottomRows(xForBottomTriangle, k - 1);
                lines += k - bottomTriangle;
                long xInBottomTriangle = sumDec(k - 1, bottomTriangle);
//                O.debug(S.string("k                  " + (k)));
//                O.debug(S.string("bottomTriangle     " + (bottomTriangle)));
//                O.debug(S.string("xInBottomTriangle  " + (xInBottomTriangle)));
//                O.debug(S.string("xForBottomTriangle " + (xForBottomTriangle)));
//                O.debug(S.string("xdifBottomTriangle " + (xInBottomTriangle - xForBottomTriangle)));

                if (xInBottomTriangle < xForBottomTriangle) lines++;
            }
//            O.debugNewLine();
            sb.append(lines).append("\n");
        }
        System.out.println(sb);
    }

    private static long topRows(long k, long x) {
        double[] roots = new Quadratic(1, 1, -2 * x).roots();
        if (roots.length != 0) {
            long s = (long) roots[1];
            if (s >= roots[0] && s <= roots[1]) return Math.min(k, s);
        }
        return 0;
    }

    private static long bottomRows(long x, long k) {
        if (x == 0) return 0;
        long e = 1, mid = 0;
        long s = k;
//        O.debug(" --s-- " + s + " --e-- " + e + " --mid-- " + mid + " --x-- " + x + "\n");
        while (s > e) {
            mid = (s + e) / 2;
            long val = sumDec(k, mid);
//            O.debug(S.string("mid " + mid + " val " + val));
            if ((val <= x && sumDec(k, mid - 1) > x)) return mid + (x - val > 0 ? 1 : 0);
            if (val > x) {
                e = mid + 1;
            } else {
                s = mid - 1;
            }
        }
//        O.debug(S.string("mid " + mid));
        return mid;
    }

    private static long sumDec(long max, long min) {
        return sumN(max) - sumN(min - 1);
    }

    private static long sumN(long n) {
        return (n * (n + 1)) / 2;
    }

    private static long maxMessages(long k) {
        return k * k;
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
