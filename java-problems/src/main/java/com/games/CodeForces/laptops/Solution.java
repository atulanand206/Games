package com.games.CodeForces.laptops;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pair {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        if (n != 1) {
            List<Pair> laptops = new ArrayList<>();
            while (n-- > 0) laptops.add(new Pair(sc.nextInt(), sc.nextInt()));
            laptops.sort(Comparator.comparing(Pair::getKey));
            for (int i = 0; i < laptops.size() - 1; i++) {
                if (laptops.get(i).getValue() > laptops.get(i + 1).getValue()) {
                    System.out.println("Happy Alex");
                    return;
                }
            }
        }
        System.out.println("Poor Alex");
    }
}
