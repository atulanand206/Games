package com.games.LeetCode.Problems.SetMatrixZeroes;

import com.games.Utils;
import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void setMatrix() {
        int[][] matrix = ListUtils.array2DOf("[[1,1,1],[1,0,1],[1,1,1]]");
        new Solution().setZeroes(matrix);
        ListUtils.print2D(matrix);
        Utils.assertSame2DArray(matrix, ListUtils.array2DOf("[[1,0,1],[0,0,0],[1,0,1]]"));
    }

    @Test
    void setMatrix2() {
        int[][] matrix = ListUtils.array2DOf("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        new Solution().setZeroes(matrix);
        ListUtils.print2D(matrix);
        Utils.assertSame2DArray(matrix, ListUtils.array2DOf("[[0,0,0,0],[0,4,5,0],[0,3,1,0]]"));
    }
}