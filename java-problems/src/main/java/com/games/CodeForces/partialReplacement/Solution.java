package com.games.CodeForces.partialReplacement;

import com.games.chess.utils.ListUtils;

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
            String[] ns = br.readLine().split(" ");
            int n = Integer.parseInt(ns[0]);
            int k = Integer.parseInt(ns[1]);
            String s = br.readLine();
            System.out.println(new Solution().replace(s, k));
        }
    }


    public int replace(String s, int k) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*')
                ints.add(i);
        }
        if (ints.size() == 1)
            return 1;
        if (ints.size() == 2)
            return 2;
        int x = ints.get(0);
        ListUtils.print(ints);
        int count = 1;
        for (int i = 1; i < ints.size() - 1; i++) {
            if (i < ints.size() - 1 && ints.get(i) - x <= k) {
                count++;
                i++;
                break;
            }
            else {
                x = ints.get(i-1);
                i--;
                count++;
            }
        }
        return count;
    }

}
