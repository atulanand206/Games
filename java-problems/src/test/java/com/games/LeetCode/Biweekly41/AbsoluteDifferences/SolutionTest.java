package com.games.LeetCode.Biweekly41.AbsoluteDifferences;

import com.games.Utils;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void testDiffs() {
        Utils.assertSameArray(new int[]{4, 3, 5}, new Solution().getSumAbsoluteDifferences(new int[]{2, 3, 5}));
    }

    @Test
    void testDiff2s() {
        Utils.assertSameArray(new int[]{24,15,13,15,21}, new Solution().getSumAbsoluteDifferences(new int[]{1,4,6,8,10}));
    }

}