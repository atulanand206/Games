package com.games.CodeForces.reposts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> indx = new HashMap<>();
        int[] reposts = new int[n + 1];
        reposts[0] = -1;
        indx.put("polycarp", 0);
        while (n-- > 0) {
            String[] repost = br.readLine().split(" reposted ");
            String p1 = repost[0].toLowerCase();
            String p2 = repost[1].toLowerCase();
            if (!indx.containsKey(p1)) indx.put(p1, indx.size());
            int ixs = indx.get(p2);
            int ixd = indx.get(p1);
            reposts[ixd] = ixs;
        }
        System.out.println(findHeight(reposts));
    }

    static int findHeight(int[] parent) {
        int res = 1;
        for (int i = 1; i < parent.length; i++) {
            int p = i, current = 1;
            while (parent[p] != -1) {
                current++;
                p = parent[p];
            }
            res = Math.max(res, current);
        }
        return res;
    }
}
