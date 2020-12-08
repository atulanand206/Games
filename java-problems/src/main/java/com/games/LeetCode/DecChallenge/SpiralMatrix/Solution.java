package com.games.LeetCode.DecChallenge.SpiralMatrix;

public class Solution {

    public enum LastVertex {
        TOP_LEFT, TOP_RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, value = 1;
        LastVertex lastVertex = LastVertex.TOP_LEFT;
        while (i >= 0 && i < n && j >= 0 && j < n && matrix[i][j] == 0) {// n = 4, i = 2 , j =2
            matrix[i][j] = value++;
            switch (lastVertex) {
                case TOP_LEFT:
                    if (j + 1 == n || matrix[i][j + 1] != 0) {
                        lastVertex = LastVertex.TOP_RIGHT;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case TOP_RIGHT:
                    if (i + 1 == n || matrix[i + 1][j] != 0) {
                        lastVertex = LastVertex.BOTTOM_RIGHT;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case BOTTOM_RIGHT:
                    if (j - 1 == -1 || matrix[i][j - 1] != 0) {
                        lastVertex = LastVertex.BOTTOM_LEFT;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case BOTTOM_LEFT:
                    if (i - 1 == -1 || matrix[i - 1][j] != 0) {
                        lastVertex = LastVertex.TOP_LEFT;
                        j++;
                    } else {
                        i--;
                    }
            }
        }
        return matrix;
    }
}
