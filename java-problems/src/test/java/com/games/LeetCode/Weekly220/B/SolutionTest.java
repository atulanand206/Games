package com.games.LeetCode.Weekly220.B;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("stream")
    void testB(int output, int[] array) {
        Assertions.assertEquals(output, new Solution().maximumUniqueSubarray(array));
    }

    static Stream<Arguments> stream() {
        return Stream.of(
                Arguments.of(1, new int[]{1}),
                Arguments.of(1, new int[]{1, 1}),
                Arguments.of(2, new int[]{1, 2}),
                Arguments.of(17, new int[]{4, 2, 4, 5, 6}),
                Arguments.of(8, new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5})
        );
    }


}