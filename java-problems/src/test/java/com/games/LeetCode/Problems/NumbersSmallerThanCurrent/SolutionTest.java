package com.games.LeetCode.Problems.NumbersSmallerThanCurrent;

import com.games.Utils;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void testSmallerThanCurrent() {
        Utils.assertSameArray(new int[]{4, 0, 1, 1, 3}, new Solution().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}));
    }

    @Test
    void testSmallerThanCurrent2() {
        Utils.assertSameArray(new int[]{2, 1, 0, 3}, new Solution().smallerNumbersThanCurrent(new int[]{6, 5, 4, 8}));
    }

    @Test
    void testSmallerThanCurrent3() {
        Utils.assertSameArray(new int[]{0, 0, 0, 0}, new Solution().smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}));
    }
}