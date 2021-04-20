package com.games.CF.IARCS.discrepanciesInTheVotersList;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        while(n1-- > 0) map.merge(sc.nextInt(), 1, Integer::sum);
        while(n2-- > 0) map.merge(sc.nextInt(), 1, Integer::sum);
        while(n3-- > 0) map.merge(sc.nextInt(), 1, Integer::sum);
        List<Integer> collect = map.entrySet().stream()
                .filter(x -> x.getValue() >= 2)
                .map(Map.Entry::getKey)
                .sorted().collect(Collectors.toList());
        System.out.println(collect.size());
        for (int i : collect) System.out.println(i);
    }
}
