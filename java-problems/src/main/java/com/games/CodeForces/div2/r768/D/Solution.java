package com.games.CodeForces.div2.r768.D;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Problem: CodeForces 1629D
 *
 * @author atulanand
 */
public class Solution {

    public static String solve(String[] A) {
        for (String s : A) if (allSame(s.toCharArray())) return "YES";
        List<String> strings = new ArrayList<>(Arrays.asList(A));
        Collections.sort(strings);
        List<String> lsst = new ArrayList<>(strings);
        lsst.sort(Comparator.comparingInt(a -> a.charAt(a.length() - 1)));
        O.debug(S.string(strings));
        O.debug(S.string(lsst));
        boolean found;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                found = true;
                int s = 0, e = strings.get(j).length() - 1;
                while (s < A[i].length() && e >= 0) {
                    if (strings.get(i).charAt(s) != strings.get(j).charAt(e)) {
                        found = false;
                        break;
                    }
                    s++;
                    e--;
                }
                if (found) return "YES";
            }
        }
        return "NO";
    }

    private static boolean allSame(char[] toCharArray) {
        return toCharArray[0] == toCharArray[toCharArray.length - 1];
    }

    public static void main(String[] args) throws IOException {
        O.attach();
        BufferedReader br = new BufferedReader(I.reader(true));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = inputInt(br);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = inputInt(br);
            String[] in = new String[n];
            for (int i = 0; i < n; i++)
                in[i] = br.readLine();
            sb.append(solve(in)).append("\n");
        }
        System.out.println(sb);
    }

    public static int inputInt(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] inputIntArray(BufferedReader br) throws IOException {
        String[] spec = br.readLine().split(" ");
        int[] arr = new int[spec.length];
        for (int i = 0; i < spec.length; i++)
            arr[i] = Integer.parseInt(spec[i]);
        return arr;
    }
}
