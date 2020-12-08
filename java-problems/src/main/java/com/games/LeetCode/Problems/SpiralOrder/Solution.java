package com.games.LeetCode.Problems.SpiralOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public enum LastVertex {
        TOP_LEFT, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        int xn = matrix.length, yn = matrix[0].length;
        boolean[][] accounted = new boolean[xn][yn];
        int i = 0, j = 0;
        LastVertex lastVertex = LastVertex.TOP_LEFT;
        while (i >= 0 && i < xn && j >= 0 && j < yn && spiralOrder.size() != xn * yn) {// n = 4, i = 2 , j =2
            spiralOrder.add(matrix[i][j]);
            accounted[i][j] = true;
            System.out.printf("(i : %d, j : %d)\n", i, j);
            System.out.println(lastVertex.name());
            switch (lastVertex) {
                case TOP_LEFT:
                    if (j + 1 == xn) {
                        lastVertex = LastVertex.TOP_RIGHT;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case TOP_RIGHT:
                    if (i + 1 == yn) {
                        lastVertex = LastVertex.BOTTOM_RIGHT;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case BOTTOM_RIGHT:
                    if (j - 1 == -1) {
                        lastVertex = LastVertex.BOTTOM_LEFT;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case BOTTOM_LEFT:
                    if (i - 1 == -1) {
                        lastVertex = LastVertex.TOP_LEFT;
                        j++;
                    } else {
                        i--;
                    }
            }
        }
        return spiralOrder;
    }
}
