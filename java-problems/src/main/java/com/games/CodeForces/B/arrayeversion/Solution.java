package com.games.CodeForces.B.arrayeversion;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * Problem: CodeForces 1585B
 *
 * @author atulanand
 */
public class Solution {

    private int solve(int[] A) {
        int res = 0;
        int[] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        Arrays.sort(B);
        if (B[0] == B[B.length - 1] || B[B.length - 1] == A[A.length - 1]) return 0;
        int l = 0, r = B.length - 1;
        while (0 < r) {
            if (A[r] == B[B.length - 1]) break;
            l = find(B, B.length - 1, A[r]) + 1;
            int x = A[r--];
            while (A[r] <= x) r--;
            res++;
        }
        return res;
    }

    private int find(int[] A, int r, int target) {
        int ans = r + 1;
        int l = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] > target) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = inputInt(br);
            int[] x = inputIntArray(br);
            sb.append(new Solution().solve(x)).append("\n");
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
