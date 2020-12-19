package com.games.LeetCode.Problems.Search2DMatrix;

import com.games.chess.utils.ListUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void test2dSearch(String array, int target, boolean state) {
        if (state)
            assertTrue(new Solution().searchMatrix(ListUtils.array2DOf(array), target));
        else
            assertFalse(new Solution().searchMatrix(ListUtils.array2DOf(array), target));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]", 3, true),
                Arguments.of("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]", 13, false),
                Arguments.of("[[]]", 0, false),
                Arguments.of("[[1]]", 2, false),
                Arguments.of("[[1]]", 1, true),
                Arguments.of("[[1],[2]]", 2, true),
                Arguments.of("[[1],[2]]", 3, false)
        );
    }

}