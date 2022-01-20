package com.games.CodeForces.arrayoperations;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Problem: CodeForces 1618D
 *
 * @author atulanand
 */
public class Solution {

    public static long solve(long[] arr, long k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for  (long a : arr) q.add(a);
        while (k-- > 0 && q.size() > 1) {
            long a = q.poll();
            long b = q.poll();
            q.add(a/b);
        }
        return q.stream().reduce(0L, Long::sum);
    }


    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long[] x = inputLongArray(br);
            long k = x[1];
            long[] q = inputLongArray(br);
            sb.append(solve(q, k)).append("\n");
        }
        System.out.println(sb);
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
