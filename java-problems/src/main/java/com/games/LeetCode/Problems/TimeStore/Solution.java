package com.games.LeetCode.Problems.TimeStore;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static class Item {
        private String value;
        private int timestamp;

        Item(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    static class TimeMap {

        Map<String, Map<String, Set<Integer>>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            Map<String, Set<Integer>> items = map.getOrDefault(key, new HashMap<>());
            Set<Integer> set = items.getOrDefault(value, new HashSet<>());
            set.add(timestamp);
            items.put(value, set);
            map.put(key, items);
        }

        public String get(String key, int timestamp) {
            Map<String, Set<Integer>> items = map.get(key);
            if (items == null || items.isEmpty())
                return "";
            List<Item> list = new ArrayList<>();
            for (Map.Entry<String, Set<Integer>> item : items.entrySet()) {
                List<Integer> collect = item.getValue().stream().filter(it -> it <= timestamp).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    list.add(new Item(item.getKey(), Collections.max(collect)));
                }
            }
            if (list.isEmpty())
                return "";
            Item max = Collections.max(list, Comparator.comparing(t -> t.timestamp));
            return max.value;
        }
    }
}
