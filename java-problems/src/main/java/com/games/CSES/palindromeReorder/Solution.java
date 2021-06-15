package com.games.CSES.palindromeReorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) map.merge(ch, 1, Integer::sum);
        int oddVals = 0;
        for (int entry : map.values()) if (entry % 2 != 0) oddVals += 1;
        if (str.length() % 2 != 0 && oddVals > 1) System.out.println("NO SOLUTION");
//        if (str.length() % 2 == 0 )
    }


}
