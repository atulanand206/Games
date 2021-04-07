package com.games.CodeForces.sportMafia;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(), k = sc.nextInt();
        List<Integer> adds = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();
        int i = 0;
        int start = 0;
        int count = 0;
        while (i < Integer.MAX_VALUE) {
            adds.add(start + i);
            count += adds.get(i);
            subs.add(n - adds.get(i));
            if (count - subs.get(i) == k)
                break;
            i++;
        }
        System.out.println(subs.get(i));
    }
}