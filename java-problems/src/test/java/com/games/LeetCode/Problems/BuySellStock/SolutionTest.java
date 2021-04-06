package com.games.LeetCode.Problems.BuySellStock;

import com.games.chess.utils.ListUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testBuySell(int[] input, int output) {
        assertEquals(output, new Solution().maxProfit(input));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void testPips(int input, int output) {
        assertEquals(output, new Solution().pips(input));
    }

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1, 20),
                Arguments.of(4, 44 + 4*4)
        );
    }

    @Test
    void testWorthyMatrix() {
        int[][] ints = ListUtils.array2DOf("[[2,2,3],[3,4,5],[4,5,5]]");
//        int[][] ints = ListUtils.array2DOf("[[1,1,1,1,7],[2,2,2,2,2],[3,3,6,7,9],[2,3,4,4,5],[1,1,3,5,5]]");
        int k = 9;
        t(ints, k);
    }

    @Test
    void testWorthyMatrix2() {
//        int[][] ints = ListUtils.array2DOf("[[2,2,3],[3,4,5],[4,5,5]]");
        int[][] ints = ListUtils.array2DOf("[[1,8,15,22,29,36,43],[2,9,16,23,30,37,44],[3,10,17,24,31,38,45],[4,11,18,25,32,39,46],[5,12,19,26,33,40,47],[6,13,20,27,34,41,48],[7,14,21,28,35,42,49]]");
        int k = 27;
        t(ints, k);
    }

    private void t(int[][] ints, int k) {
        ListUtils.print2D(ints);
        long[][] a = ListUtils.long2DOf(ints);
//        ListUtils.print2D(a);
//        ListUtils.print2D(Solution.prefixSum2D(a));
//        ListUtils.print2D(Solution.avgs(Solution.prefixSum2D(a), k));
        int x = Solution.worthyMatrices(a, k);
        System.out.println();
        System.out.println(x);
    }
}
