package com.games.LeetCode.Problems.MergeIntervals;

import com.games.Utils;
import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMergeIntervals() {
        int[][] ints = ListUtils.array2DOf("[[1,3],[8,10],[2,6],[15,18]]");
        int[][] output = ListUtils.array2DOf("[[1,6],[8,10],[15,18]]");
        int[][] merge = new Solution().merge(ints);
        Utils.assertSame2DArray(output, merge);
    }

    @Test
    void testMergeIntervals2() {
        int[][] ints = ListUtils.array2DOf("[[1,4],[2,3]]");
        int[][] output = ListUtils.array2DOf("[[1,4]]");
        int[][] merge = new Solution().merge(ints);
        Utils.assertSame2DArray(output, merge);
    }

}