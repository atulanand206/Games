package com.games.LeetCode.Problems.Subsets;

import com.games.Utils;
import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void testSubsets() {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        ListUtils.print2D(subsets);
        Utils.assertSame2DList(ListUtils.list2DOf("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]"), subsets);
    }

    @Test
    void test2DListParser() {
        String str = "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]";
        ListUtils.print2D(ListUtils.list2DOf(str));
    }

}