package com.games.CodeForces.C.letters;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Problem: CodeForces 978C
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(long[] capacities, long[] roomNos) {
        long[] pf = prefixSum(capacities);
        StringBuilder sb = new StringBuilder();
        for (long room : roomNos) {
            int dorm = findGreaterOrEqual(pf, room);
            long tillThis = dorm == 0 ? 0 : pf[dorm - 1];
            long inThis = room - tillThis;
            sb.append(dorm + 1).append(" ").append(inThis).append("\n");
        }
        return sb.toString();
    }

    private static int findGreaterOrEqual(long[] capacities, long room) {
        int low = 0, high = capacities.length - 1;
        int ans = high + 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (capacities[mid] >= room) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static long[] prefixSum(long[] rooms) {
        long[] pf = new long[rooms.length];
        pf[0] = rooms[0];
        for (int i = 1; i < rooms.length; i++)
            pf[i] = pf[i - 1] + rooms[i];
        return pf;
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            inputIntArray(br);
            sb.append(solve(inputLongArray(br), inputLongArray(br)));
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

    public static long[] inputLongArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        long[] arr = new long[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Long.parseLong(spec[i]);
        return arr;
    }
}
