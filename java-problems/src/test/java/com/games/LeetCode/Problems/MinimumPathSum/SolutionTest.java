package com.games.LeetCode.Problems.MinimumPathSum;

import com.games.chess.utils.ListUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testMinPathSum(String input, int output) {
        assertEquals(output, new Solution().minPathSum(ListUtils.array2DOf(input)));
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("[[1,3,1],[1,5,1],[4,2,1]]", 7),
                Arguments.of("[[1,2,3],[4,5,6]]", 12),
                Arguments.of("[[1,2,3]]", 6)
        );
    }
}