package com.games.CodeForces.bitPlusPlus;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int val = 0;
        int n = sc.nextInt();
        String s;
        while (n-- > 0 && (s = sc.next()) != null)
            if (s.contains("+"))
                val++;
            else if (s.contains("-"))
                val--;
        System.out.println(val);
    }
}