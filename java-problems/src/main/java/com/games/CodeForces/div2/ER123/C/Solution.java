package com.games.CodeForces.div2.ER123.C;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: CodeForces 1644C
 *
 * @author atulanand
 */

class Solutin {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] map = charMap(s);
        int i = map.length - 1;
        while (map[i] == 0) {
            i--;
        }
        int j = i - 1;
        while (map[j] == 0) {
            j--;
        }
        System.out.println(i + " " + j);

        System.out.println(i + " " + j);
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            System.out.println(i + " " + j);
            char largest = (char) (i + 97);
            char second = (char) (j + 97);
            int cnt = 0;
            while (cnt < repeatLimit && cnt < map[i]) {
                sb.append(largest);
                cnt++;
            }
            map[i] -= cnt;
            if (map[i] > 0) {
                cnt = 0;
                while (cnt < repeatLimit && cnt < map[j]) {
                    sb.append(second);
                    cnt++;
                }
                map[j] -= cnt;
            } else {
                while (i > 0 && map[i] == 0) {
                    i--;
                }
                j = i - 1;
                while (j > 0 && map[j] == 0) {
                    j--;
                }
            }
        }
        return sb.toString();
    }

    private int[] charMap(String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[(int) ch - 97]++;
        }
        return map;
    }
}
public class Solution {

    public static String solve(int[] arr, int x) {
        StringBuilder sb = new StringBuilder();
        int[] required = requiredChanges(arr, x);
        PriorityQueue<Integer> maxSums = maxSubArray(arr);

        O.debug(S.string(arr));
        O.debug(S.string(required));
        O.debug(S.string(maxSums));
        O.debugNewLine();
        return sb.toString();
    }

    public static PriorityQueue<Integer> maxSubArray(final int[] A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if (Arrays.stream(A).allMatch(x -> x <= 0)) {
            int max = Integer.MIN_VALUE;
            for (int i : A) {
                max = Math.max(max, i);
            }
            queue.add(0);
            return queue;
        }
        int ans = Integer.MIN_VALUE, sum = 0;
        for (int i : A) {
            sum += i;
            if (sum < 0) sum = 0;
            else {
                if (sum != 0) {
                    queue.add(sum);
                }
            }
        }
        if (sum != 0) {
            queue.add(sum);
        }
        return queue;
    }

    private static int[] requiredChanges(int[] arr, int x) {
        int[] required = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                required[i] = -(arr[i] / x);
                if (arr[i] % x != 0) {
                    required[i]++;
                }
            }
        }
        return required;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
//        while (t-- > 0) {
//            int[] specs = inputIntArray(br);
//            sb.append(solve(inputIntArray(br), specs[1]));
//        }
////        for (int i = 3; i <= 50; i++) {
////            sb.append(solve(i));
////        }
        O.debug(S.string(new Solutin().repeatLimitedString("cczazcc", 3)));
        O.debug(S.string(sb));
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
