package com.games.CodeForces.B.cardconstructions;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: CodeForces 1345B
 *
 * @author atulanand
 */
public class Solution {

    private int solve(int[] pyramids, int A) {
        int res = 0;
        while (A > 1) {
            int idx = find(pyramids, pyramids.length - 1, A);
            A -= pyramids[idx];
            res++;
        }
        return res;
    }

    private int find(int[] A, int r, int target) {
        int ans = 0;
        int l = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] <= target) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    private static int[] possible() {
        List<Integer> res = new ArrayList<>();
        res.add(2);
        int i = 2   ;
        long pyr;
        while ((pyr = next(res, i)) <= 1_000_000_000) {
            res.add((int) pyr);
            i++;
        }
        int[] pyramids = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            pyramids[i] = res.get(i);
        }
        return pyramids;
    }

    private static int next(List<Integer> res, int i) {
        return 3 * i - 1 + res.get(res.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        int[] pyramids = possible();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = inputInt(br);
            sb.append(new Solution().solve(pyramids, m)).append("\n");
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
