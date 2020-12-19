package com.games.LeetCode.Problems.Search2DMatrix;

public class Solution {

    int itemsInRow;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        int end = matrix.length * matrix[0].length - 1;
        if (end < 1)
            return matrix[0][0] == target;
        itemsInRow = matrix[0].length;
        return searchMatrix(matrix, target, 0, end);
    }

    private boolean searchMatrix(int[][] matrix, int target, int start, int end) {
        if (end < start)
            return false;
        int mid = (start + end) / 2;
        int midI = mid / itemsInRow;
        int midJ = mid % itemsInRow;
        System.out.printf("%d : %d : ", start, end);
        System.out.printf("%d : %d : %d \n", mid, midI, midJ);
        if (matrix[midI][midJ] < target)
            return searchMatrix(matrix, target, mid + 1, end);
        else if (matrix[midI][midJ] > target)
            return searchMatrix(matrix, target, start, mid - 1);
        return true;
    }
}
