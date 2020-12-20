package com.games.LeetCode.Weekly220.A;

import com.games.chess.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        List<String> blocks = getParts(number, 3);
        if (blocks.size() > 1) {
            int i = blocks.size() - 1;
            if (blocks.get(i).length() == 1) {
                combine(blocks, i);
            }
        }
        return result(blocks);
    }

    private void combine(List<String> blocks, int i) {
        String s = blocks.get(i - 1);
        String s1 = blocks.get(i);
        s = s + s1;
        blocks.set(i - 1, s);
        blocks.remove(i);
    }

    private String result(List<String> blocks) {
        if (blocks.isEmpty()) {
            return "";
        }
        if (blocks.size() == 1) {
            if (blocks.get(0).length() > 3) {
                List<String> parts = getParts(blocks.get(0), 2);
                blocks.set(blocks.size() - 1, parts.get(0));
                blocks.add(parts.get(1));
            }
        }
        String s = blocks.get(blocks.size() - 1);
        if (s.length() == 4) {
            List<String> parts = getParts(s, 2);
            blocks.set(blocks.size() - 1, parts.get(0));
            blocks.add(parts.get(1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(blocks.get(0));
        for (int i = 1; i < blocks.size(); i++)
            sb.append("-").append(blocks.get(i));
        return sb.toString();
    }

    private static List<String> getParts(String string, int partitionSize) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i = 0; i < len; i += partitionSize) {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
    }
}
