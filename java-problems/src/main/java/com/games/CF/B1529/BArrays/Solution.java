package com.games.CF.B1529.BArrays;
// Working program with FastReader

import com.games.chess.utils.ListUtils;

import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int T = fs.nextInt();
        while (T-- > 0){
            int n = fs.nextInt();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < n; i++) li.add(fs.nextInt());
            Collections.sort(li);
            int[][] dp = new int[li.size()][li.size()];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j <  dp.length; j++){
                    dp[i][j] = Math.abs(li.get(i) - li.get(j));
                }
            }

            ListUtils.printDp(dp, li);

            int s = 0, e = li.size() - 1, max = Collections.max(li);
            while (s != e) {
                if (li.get(e) - li.get(s) < max) {
                    e--;
                }
            }
//            Collections.sort(li);
//            System.out.println(li);
//            int sumTillCheck = 0;
//            int count = 0;
//            for (int i = li.size() - 1; i >= 0; i--) {
//                sumTillCheck += li.get(i);
//                double avg = (double) sumTillCheck / (li.size() - i - count);
//                int tmp = 0;
//                for (int j = i; j < li.size() - count; j++) {
//                    if (li.get(j) > avg) {
//                        tmp++;
//                        sumTillCheck -= li.get(j);
//                    }
//                    System.out.println(sumTillCheck + " " + count + " " + avg);
//                }
//                count += tmp;
//            }
//            if (count != 0) System.out.println(count);
//            else System.out.println(0);
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(next());
            return arr;
        }
    }
}

