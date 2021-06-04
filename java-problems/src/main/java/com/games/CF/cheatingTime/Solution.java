package com.games.CF.cheatingTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        while (t-- > 0) {
            int[] spec = inputIntArray(br);
            int n = spec[0], k = spec[1], f = spec[2];
            List<Interval> ranges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int[] range = inputIntArray(br);
                ranges.add(new Interval(range[0], range[1]));
            }
            List<Interval> merged = mergeIntervals(ranges);
            int sum = merged.get(0).start;
            for (int i = 1; i < merged.size(); i++)
                sum += merged.get(i).start - merged.get(i - 1).end;
            sum += f - merged.get(merged.size() - 1).end;
            System.out.println(sum >= k ? "YES" : "NO");
        }
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> arr) {
        arr.sort(Comparator.comparingInt(i -> i.start));
        int index = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(index).end >= arr.get(i).start) {
                arr.get(index).end = Math.max(arr.get(index).end, arr.get(i).end);
                arr.get(index).start = Math.min(arr.get(index).start, arr.get(i).start);
            } else {
                index++;
                arr.set(index, arr.get(i));
                int k = index - i;
                while (k-- > 0) if (arr.size() > i) arr.remove(i);
            }
        }
        return arr.subList(0, index + 1);
    }


    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++) arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
