package com.games.LeetCode.Problems.MultiplyStrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void testMultiplyStrings(String output, String num1, String num2) {
        assertEquals(output, new Solution().multiply(num1, num2));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of("6", "2", "3"),
                Arguments.of("0", "0", "0"),
                Arguments.of("0", "0", "1"),
                Arguments.of("0", "0", ""),
                Arguments.of("56088", "123", "456"),
                Arguments.of("100350557280", "312315", "321312"),
                Arguments.of("0", "9133", "0")
        );
    }

}