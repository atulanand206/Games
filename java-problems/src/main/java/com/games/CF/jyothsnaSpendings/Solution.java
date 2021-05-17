package com.games.CF.jyothsnaSpendings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static class Item {
        private String name;
        private Integer value;

        public Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Item> entries = new ArrayList<>();
            while (n-- > 0) {
                String in = br.readLine();
                String name = in.split(" ")[0];
                int val = Integer.parseInt(in.split(" ")[1]);
                entries.add(new Item(name, val));
            }
            entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            Map<String, Integer> countMap = new HashMap<>();
            for (int i = 0; i < entries.size(); i++) {
                String name = entries.get(i).getName();
                if (countMap.getOrDefault(name, 0) < 3) {
                    countMap.merge(name, 1, Integer::sum);
                } else {
                    entries.remove(i);
                    i--;
                }
            }
            Map<String, Integer> res = new TreeMap<>(Comparator.reverseOrder());
            for (Item item : entries) {
                res.merge(item.getName(), item.getValue(), Integer::sum);
            }
            List<Map.Entry<String, Integer>> entries1 = new ArrayList<>(res.entrySet());
            entries1.sort((o1, o2) -> {
                if (o2.getValue().compareTo(o1.getValue()) == 0)
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue().compareTo(o1.getValue());
            });
            System.out.println(entries1.get(0).getKey() + " " + entries1.get(0).getValue());
        }
    }
}