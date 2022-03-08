package com.games.CodeForces.div3.r776.C;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem: CF 1650C
 *
 * @author atulanand
 */

public class Solution {
    static class Number {
        int loc;
        int val;
        int index;
        static Number of(int loc, int val, int index) {
            Number n = new Number();
            n.loc = loc;
            n.val = val;
            n.index = index;
            return n;
        }

        @Override
        public String toString() {
            return "(" +loc + ", " + val +")\n";
        }
    }
    static class Result {

        public String solve(int[][] edges, int n) {
            List<Number> list = new ArrayList<>();
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                list.add(Number.of(edge[0], edge[1], i + 1));
            }
            List<Number> numbers = list.stream()
                    .sorted(Comparator.comparingInt(num -> num.val))
                    .limit(n * 2L)
                    .sorted(Comparator.comparingInt(num -> num.loc))
                    .collect(Collectors.toList());
            int sum = numbers.stream()
                    .map(x -> x.val)
                    .reduce(0, Integer::sum);
            StringBuilder sb = new StringBuilder();
            sb.append(sum).append("\n");
            int i = 0, j = numbers.size() - 1;
            while (i < j) {
                sb.append(numbers.get(i).index).append(" ").append(numbers.get(j).index);
                i++;
                j--;
                sb.append("\n");
            }
            return sb.toString();
        }

        private int f(int ch, int ch1) {
            O.debug(S.string(ch + " " + ch1));
            return ch / ch1 + ch % ch1;
        }
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            int[] specs = inputIntArray(br);
            int[][] edges = new int[specs[1]][];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = inputIntArray(br);
            }
            sb.append(new Result().solve(edges, specs[0])).append("\n");
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
