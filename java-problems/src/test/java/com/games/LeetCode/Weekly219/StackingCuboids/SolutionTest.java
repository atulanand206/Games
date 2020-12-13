package com.games.LeetCode.Weekly219.StackingCuboids;

import org.junit.jupiter.api.Test;

import static com.games.chess.utils.ListUtils.array2DOf;
import static com.games.chess.utils.ListUtils.list2DOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testStackingCuboids1() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[50,45,20],[95,37,53],[45,23,12]]"));
        assertEquals(190, solution.maxHeight(lists));
    }

    @Test
    void testStackingCuboids2() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[38,25,45],[76,35,3]]"));
        assertEquals(76, solution.maxHeight(lists));
    }

    @Test
    void testStackingCuboids3() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]"));
        assertEquals(102, solution.maxHeight(lists));
    }

    @Test
    void testStackingCuboids4() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[1,7,20],[2,6,20]]"));
        assertEquals(20, solution.maxHeight(lists));
    }

    @Test
    void testStackingCuboids5() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[1,7,20],[2,6,10]]"));
        assertEquals(20, solution.maxHeight(lists));
    }

    @Test
    void testStackingCuboids6() {
        Solution solution = new Solution();
        int[][] lists = array2DOf(list2DOf("[[12,76,13],[68,55,30],[48,85,52],[91,7,41],[29,65,35]]"));
        assertEquals(161, solution.maxHeight(lists));
    }

}