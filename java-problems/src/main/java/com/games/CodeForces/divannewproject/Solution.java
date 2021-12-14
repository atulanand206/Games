package com.games.CodeForces.divannewproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem: CodeForces 1614B
 *
 * @author atulanand
 */
public class Solution {

    private static final int MOD = (int) 1E9 + 7;

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            int[] q = inputIntArray(br);
            int home = (n + 1) / 2;
            int[] res = placeBuildings(q, home);
            BigInteger y = getTotalTime(q, home, res);
            createOutput(sb, home, res, y);
        }
        System.out.println(sb);
    }

    private static int[] placeBuildings(int[] q, int home) {
        List<Pair> collect = IntStream.range(0, q.length)
                .mapToObj(i -> new Pair(q[i], i))
                .sorted(Comparator.comparingInt(a -> a.val))
                .collect(Collectors.toList());
        Collections.reverse(collect);
        int left = home - 1;
        int right = home + 1;
        int[] res = new int[q.length];
        boolean x = false;
        for (Pair building : collect) {
            res[building.idx] = x ? left-- : right++;
            x = !x;
        }
        return res;
    }

    private static BigInteger getTotalTime(int[] q, int home, int[] res) {
        BigInteger y = BigInteger.ZERO;
        for (int i = 0; i < q.length; i++) {
            BigInteger dist = new BigInteger(String.valueOf(Math.abs(res[i] - home)));
            BigInteger times = new BigInteger(String.valueOf(q[i]));
            BigInteger cont = dist.multiply(times).multiply(BigInteger.valueOf(2));
            y = y.add(cont);
        }
        return y;
    }

    private static void createOutput(StringBuilder sb, int home, int[] res, BigInteger y) {
        sb.append(y).append("\n");
        sb.append(home).append(" ");
        for (int i : res)
            sb.append(i).append(" ");
        sb.append("\n");
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
