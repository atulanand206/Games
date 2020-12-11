package com.games.LeetCode.Problems.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++)
                row.add(1);
            result.add(row);
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                int a = result.get(i - 1).get(j - 1);
                int b = result.get(i - 1).get(j);
                result.get(i).set(j, a + b);
            }
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex+1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++)
                row.add(1);
            result.add(row);
        }
        for (int i = 2; i < rowIndex+1; i++) {
            for (int j = 1; j < i; j++) {
                int a = result.get(i - 1).get(j - 1);
                int b = result.get(i - 1).get(j);
                result.get(i).set(j, a + b);
            }
        }
        return result.get(rowIndex);
    }
}
