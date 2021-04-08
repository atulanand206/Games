package com.games.CodeForces.abCompilation;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        Map<Integer, Integer> third = new HashMap<>();

        for (int i = 0; i < n; i++)
            first.merge(sc.nextInt(), 1, Integer::sum);
        for (int i = 0; i < n - 1; i++)
            second.merge(sc.nextInt(), 1, Integer::sum);
        for (int i = 0; i < n - 2; i++)
            third.merge(sc.nextInt(), 1, Integer::sum);

        for (Map.Entry<Integer, Integer> entry : second.entrySet())
            first.merge(entry.getKey(), entry.getValue() * -1, Integer::sum);
        for (Map.Entry<Integer, Integer> entry : third.entrySet())
            second.merge(entry.getKey(), entry.getValue() * -1, Integer::sum);

        for (Map.Entry<Integer, Integer> entry : first.entrySet())
            if (entry.getValue() == 1)
                System.out.println(entry.getKey());
        for (Map.Entry<Integer, Integer> entry : second.entrySet())
            if (entry.getValue() == 1)
                System.out.println(entry.getKey());
    }
}
