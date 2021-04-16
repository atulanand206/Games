package com.games.CF.euron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] d = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(d[i]);
        List<Integer> arr = new ArrayList<>();
        int vio = 0;
        for (int i = 0; i < n; i++) {
            int x = upperBound(arr, a[i]);
            if (x == Integer.MAX_VALUE) arr.add(a[i]);
            else {
                arr.add(x, a[i]);
                vio += Math.abs(i - x);
            }
        }
        System.out.println(vio);
    }

    private static int upperBound(List<Integer> stacks, int v) {
        int s = 0, e = stacks.size() - 1;
        int mid;
        int res = Integer.MAX_VALUE;
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

    private static int lowerBound(List<Integer> stacks, int v) {
        int s = 0, e = stacks.size() - 1;
        int mid;
        int res = Integer.MAX_VALUE;
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
