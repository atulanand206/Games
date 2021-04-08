package com.games.CodeForces.taxi;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        while (n-- > 0)
            map.merge(sc.nextInt(), 1, Integer::sum);
        int res = 0;
        int fours = map.getOrDefault(4, 0);
        int threes = map.getOrDefault(3, 0);
        int twos = map.getOrDefault(2, 0);
        int ones = map.getOrDefault(1, 0);
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        res += fours;
        fours = 0;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        int threesUsed = Math.min(threes, ones);
        ones -= threesUsed;
        threes -= threesUsed;
        res += threesUsed;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        res += threes;
        threes = 0;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        int twosUsed = twos / 2;
        twos -= twosUsed * 2;
        res += twosUsed;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        int twoOnes = Math.min(twos, 2 * ones);
        res += twoOnes;
        twos -= twoOnes;
        ones -= twoOnes * 2;
//        System.out.printf("TT%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        res += twos;
        twos = 0;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        res += ones / 4;
        ones = ones % 4;
//        System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        if (ones < 4 && ones > 0) {
            res += 1;
            ones = 0;
//            System.out.printf("%d : %d : %d : %d : %d\n", ones, twos, threes, fours, res);
        }
        System.out.println(res);
    }
}
