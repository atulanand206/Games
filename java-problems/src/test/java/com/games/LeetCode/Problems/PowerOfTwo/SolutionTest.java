package com.games.LeetCode.Problems.PowerOfTwo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void testPowerOfTwo(int number, boolean isPower) {
        assertEquals(isPower, new Solution().isPowerOfTwo(number));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(-2, false),
                Arguments.of(1, true),
                Arguments.of(255, false),
                Arguments.of(256, true),
                Arguments.of(1023, false),
                Arguments.of(16, true),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, false)

        );
    }

}