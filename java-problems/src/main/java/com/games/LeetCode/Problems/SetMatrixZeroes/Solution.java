package com.games.LeetCode.Problems.SetMatrixZeroes;

/**
 * Solution to LeetCode Problem #73. Set Matrix Zeroes.
 * <p>
 * <p>
 * First row & column are traversed to check if the matrix contains a zero
 * in the first row and column and stored as a flag.
 * The flag is required because in the subsequent steps the values present
 * in the first row and column is overwritten by the information which
 * signifies if the corresponding row or column has a zero.
 * The array is traversed and is made zero if the row or column of the cell has a zero
 * at the corresponding first row and column determined in the previous step.
 * The flags are now used to make the first row and first column as zeroes if true.
 * <p>
 * <p>
 * Space Complexity - O(1) : Only a couple flags have been initialized.
 * Time Complexity - O(mxn) : 2D Array traversal with visiting every cell.
 *
 * @author Atul Anand
 * @version 1.0 - 17th Dec 2020
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        boolean firstRow = isFirstRowWithZero(matrix);
        boolean firstColumn = isFirstColumnWithZero(matrix);

        makeFirstRowAndColumnZero(matrix);
        makeInternalCellsZero(matrix);

        if (firstRow)
            makeFirstRowZero(matrix);
        if (firstColumn)
            makeFirstColumnZero(matrix);
    }

    private void makeFirstColumnZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][0] = 0;
    }

    private void makeFirstRowZero(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++)
            matrix[0][i] = 0;
    }

    private void makeInternalCellsZero(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
    }

    private void makeFirstRowAndColumnZero(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
    }

    private boolean isFirstColumnWithZero(int[][] matrix) {
        for (int[] row : matrix)
            if (row[0] == 0)
                return true;
        return false;
    }

    private boolean isFirstRowWithZero(int[][] matrix) {
        int[] row = matrix[0];
        for (int item : row)
            if (item == 0)
                return true;
        return false;
    }
}
