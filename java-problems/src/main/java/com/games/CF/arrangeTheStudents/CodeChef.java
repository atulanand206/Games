package com.games.CF.arrangeTheStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(sc.readLine());
        while (t-- > 0) {
            String a = sc.readLine();
            char[] chs = a.toCharArray();
            int[] left = new int[a.length()];
            int start = 0, count = 0;
            int islands = 0;
            if (chs[0] == '1') {
                count++;
                islands++;
                left[0] = 1;
            }
            for (int i = 1; i < chs.length; i++) {
                if (chs[i] == '1') count++;
                if (chs[i] == '0' && chs[i - 1] == '1') {
                    for (int j = start; j < i; j++)
                        left[j] = count;
                }
                if (chs[i] == '0') count = 0;
                if (chs[i] == '1' && chs[i - 1] == '0') {
                    islands++;
                    start = i;
                }
            }
            int res = 0;
            int max = 0;

            for (int i = 0; i < left.length; i++) {
                max = Math.max(max, left[i]);
                int k = 0;
                if (left[i] == 0) {
                    k = 1;
                    if (i > 0) k += left[i - 1];
                    if (i < left.length - 1) k += left[i + 1];
                }
                res = Math.max(res, k);
            }
            if (max >= left.length - 1 || islands == 1) {
                res = max;
            }
            System.out.println(res);
        }
    }
}
