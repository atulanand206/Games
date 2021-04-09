package com.games.CodeForces.twoTeamsComposing;

import com.games.chess.utils.ListUtils;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) map.merge(sc.nextInt(), 1, Integer::sum);
            int popEle = 0;
            int common = 0, maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 1 && entry.getValue() > common) {
                    common = entry.getValue();
                    maxKey = entry.getKey();
                    popEle = 1;
                }
            }
            if (popEle != 0) {
                map.remove(maxKey);
                int unique = map.size();
                if (common - unique >= 2) System.out.println(unique + 1);
                if (common - unique == 1) System.out.println(unique);
                else System.out.println(common);
            } else {
                if (map.size() == 1) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            }
        }
    }
}


// Distinct, Common => Min()
// Distinct & 1 from same common, Common - 1 => Min()
// Distinct & 1 from diff common, Common => Min()
// Max of all three.

// Distinct ~ Common >= 2 : Common + 2
//1
//12
//5 5 5 5 5 1 2 3 6 6 7 5