package com.games.CF.jss.maxAndPalindromes;

import com.games.chess.utils.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();
        Map<Character, Integer> charMap = chars(ss);
        ListUtils.print(charMap);
        long ones = 0, twos = 0, onlyOnes = 0;
        for (int i : charMap.values()) {
            if (i == 1) onlyOnes++;
            if (i >= 1) ones++;
            if (i >= 2) twos++;
        }
        long ans = twos * onlyOnes + (twos - 1) * (ones - onlyOnes);
        System.out.println(ans);
    }

    private static Map<Character, Integer> chars(String ss) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : ss.toCharArray()) map.merge(ch, 1, Integer::sum);
        return map;
    }
}
