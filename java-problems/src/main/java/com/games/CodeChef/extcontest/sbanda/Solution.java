package com.games.CodeChef.extcontest.sbanda;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: CodeChef IMPRS
 *
 * @author atulanand
 */
public class Solution {

    static class Item {
        int[] pt;

        static Item of(int[] pt) {
            Item it = new Item();
            it.pt = pt;
            return it;
        }

        public long getSum() {
            return pt[0] + pt[1];
        }

        public double getDist() {
            return Math.sqrt(Math.pow(pt[0], 2) + Math.pow(pt[1], 2));
        }

        @Override
        public String toString() {
            return Arrays.toString(pt);
        }
    }

    static long solve(int[][] A, int k) {
        O.debug(S.string(A));
        return Arrays.stream(A)
                .map(Item::of)
                .sorted(Comparator
                        .comparingDouble(Item::getDist)
                        .thenComparingLong(Item::getSum))
                .peek(System.out::println)
                .limit(k)
                .mapToLong(Item::getSum)
                .reduce(0, Long::sum);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int[][] arr = new int[spec[0]][2];
            int i = 0;
            while (i < spec[0])
                arr[i++] = inputIntArray(br);
            sb.append(solve(arr, spec[1])).append("\n");
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
