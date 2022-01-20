package com.games.CodeChef.jan221b.retrievearray;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem: CodeChef Long Challenge
 *
 * @author atulanand
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        String s;
        while ((s = br.readLine()) != null) {
            int x = Integer.parseInt(s.trim());
            if (x == 0) break;
            if ((x | 1) == (x + 1)) t++;
        }
        O.debug(t);
//        int t = Integer.parseInt(br.readLine().trim());
//        StringBuilder sb = new StringBuilder();
//        while (t-- > 0) {
//            int[] in = inputIntArray(br);
//            sb.append(solve(in[0], in[1])).append("\n");
//        }
//        System.out.println(sb);
    }

    private static String solve(int n, int x) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new TreeSet<>();
        int i = 1, mx = x;
        while (set.size() + 1 < n) {
            set.add(i);
            mx ^= i++;
        }
        if (!set.contains(mx)) {
            set.add(mx);
            return stringify(set);
        }
        int max = Collections.max(set);
        set.remove(max);
        int max2 = Collections.max(set);
        set.remove(max2);
        O.debug(S.string(max));
        int z = max ^ max2 ^ mx;
        O.debug(S.string(z));
        int ms = 0;
        int m = z;
        while (m > 0) {
            ms++;
            m >>= 1;
        }
        int i1 = 1 << (ms - 2);
        int f = z;
        int s = z;
        int t = z;
        while (i1 > 0) {
            if ((z & i1) == 0) {
                f |= i1;
                t |= i1;
                i1 >>= 1;
                break;
            }
            i1 >>= 1;
        }
        while (i1 > 0) {
            if ((z & i1) == 0) {
                s |= i1;
                t |= i1;
                break;
            }
            i1 >>= 1;
        }
        set.add(f);
        set.add(s);
        set.add(t);
        int k = 0;
        for (int l : set) k ^= l;
        O.debug(S.string(mx + " " + k));
        return stringify(set);
    }

    private static String stringify(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) sb.append(" ");
        }
        return sb.toString();
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        return getInts(br.readLine().split(" "));
    }

    private static int[] getInts(String[] spec) {
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
