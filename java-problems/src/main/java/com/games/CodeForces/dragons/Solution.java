package com.games.CodeForces.dragons;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Pair {
    private int key;
    private int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int s = sc.nextInt(), n = sc.nextInt();
        List<Pair> strengths = new ArrayList<>();
        while (n-- > 0) {
            strengths.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        strengths.sort(Comparator.comparing(Pair::getKey));
        for (Pair p : strengths)
            if (p.getKey() >= s) {
                System.out.println("NO");
                return;
            } else {
                s += p.getValue();
            }
        System.out.println("YES");
    }
}
