package com.games.CF.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> stacks = new ArrayList<>();
            String[] data = br.readLine().split(" ");
            int i = 0;
            while (n-- > 0) {
                int v = Integer.parseInt(data[i++]);
                int ix = findIndexToPut(stacks, v);
                if (ix == Integer.MAX_VALUE) stacks.add(v);
                else stacks.set(ix, v);
            }
            System.out.printf("%d ", stacks.size());
            for (int in : stacks) System.out.printf("%d ", in);
            System.out.println();
        }
    }

    private static int findIndexToPut(List<Integer> stacks, int v) {
        int s = 0, e = stacks.size() - 1;
        int mid;
        int res = Integer.MAX_VALUE;
        while (s <= e) {
            mid = (s + e) / 2;
            if (stacks.get(mid) > v) {
                res = Math.min(res, mid);
                e = mid - 1;
            } else s = mid + 1;
        }
        return res;
    }
}
