package com.games.LeetCode.Problems.OrderedStream;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class OrderedStream {

        private int currentIndex = 0;
        private final List<String> strings;

        public OrderedStream(int n) {
            this.strings = new ArrayList<>();
            for (int i = 0; i < n; i++)
                strings.add(null);
        }

        public List<String> insert(int id, String value) {
            List<String> strs = new ArrayList<>();
            strings.set(id - 1, value);
            for (; currentIndex < strings.size() && strings.get(currentIndex) != null; currentIndex++)
                strs.add(strings.get(currentIndex));
            return strs;
        }
    }
}
