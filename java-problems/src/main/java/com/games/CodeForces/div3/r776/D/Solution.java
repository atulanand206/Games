package com.games.CodeForces.div3.r776.D;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: CF 1650D
 *
 * @author atulanand
 */

public class Solution {

    static class Result {
        public String solve(int[] nums) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i : nums) {
                queue.add(i);
            }
            int[] res = new int[nums.length];
            int i = res.length - 1;
            while (!queue.isEmpty()) {
                while (!queue.isEmpty() && queue.peek() != queue.size()) {
                    queue.add(queue.poll());
                    res[i]++;
                }
                res[i]++;
                res[i] %= queue.size();
                queue.poll();
                i--;
            }
            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x).append(" ");
            }
            return sb.toString();
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
            sb.append(new Result().solve(inputIntArray(br))).append("\n");
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
