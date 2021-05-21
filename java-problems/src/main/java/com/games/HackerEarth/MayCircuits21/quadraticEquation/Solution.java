package com.games.HackerEarth.MayCircuits21.quadraticEquation;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final int limit = (int) 10E6;

    public static void main(String[] args) throws Exception {
        List<Long> squares = calcSquares(limit);
        printUntil(squares);
        List<Long> differences = consecutiveDifference(squares);
        printUntil(differences);
        List<Long> suffixSum = suffix(differences);
        printUntil(suffixSum);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.readLine());
        while (t-- > 0) {
            String[] spec = sc.readLine().split(" ");
            long l = Long.parseLong(spec[0]), r = Long.parseLong(spec[1]);
            int li = upperBound(squares, l);
            int ri = lowerBound(differences, r);
            int count = 0;

            System.out.println(l);
            System.out.println(r);
            System.out.println(li + " " + squares.get(li));
            System.out.println(ri + " " + squares.get(ri));
//            1
//            2132312 321321321
            for (int i = li; i < ri; i++) {
                System.out.println(suffixSum.get(i));
                long j = suffixSum.get(i) - r;
                System.out.println(j);
                long ji = upperBound(suffixSum, j);
                System.out.println(ji);
                count += (i - ji);
            }
            System.out.println(count);
        }
    }

    private static void printUntil(List<Long> differences) {
        for (int i = 0; i < 10; i++) System.out.printf("%d, ", differences.get(i));
        System.out.println();
    }

    private static List<Long> suffix(List<Long> differences) {
        List<Long> suffixes = new ArrayList<>();
        long val = 0;
        for (int i = differences.size() - 1; i >= 0; i--) {
            val = val + differences.get(i);
            suffixes.add(val);
        }
        Collections.reverse(suffixes);
        return suffixes;
    }

    private static List<Long> calcSquares(int limit) {
        List<Long> squares = new ArrayList<>();
        long val = 0;
        for (int i = 0; i <= limit; i++) {
            squares.add(val);
            val = val + 2L * i + 1;
        }
        return squares;
    }

    private static List<Long> consecutiveDifference(List<Long> list) {
        List<Long> diff = new ArrayList<>();
        for (int i = 1; i < list.size(); i++)
            diff.add(list.get(i) - list.get(i - 1));
        return diff;
    }

    private static int upperBound(List<Long> stacks, long v) {
        int s = 0, e = stacks.size() - 1;
        int mid;
        int res = stacks.size();
        while (s <= e) {
            mid = (s + e) / 2;
            if (stacks.get(mid) > v) {
                res = Math.min(res, mid);
                e = mid - 1;
            } else if (stacks.get(mid) == v) {
                return lowerBound(stacks, v + 1);
            } else s = mid + 1;
        }
        return res;
    }

    private static int lowerBound(List<Long> stacks, long v) {
        int s = 0, e = stacks.size() - 1;
        int mid;
        int res = stacks.size();
        while (s <= e) {
            mid = (s + e) / 2;
            if (stacks.get(mid) >= v) {
                res = Math.min(res, mid);
                e = mid - 1;
            } else s = mid + 1;
        }
        return res;
    }
}
