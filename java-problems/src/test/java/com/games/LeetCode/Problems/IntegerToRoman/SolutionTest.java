package com.games.LeetCode.Problems.IntegerToRoman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testIntegerToRoman() {
        assertEquals("III", new Solution().intToRoman(3));
    }

    @Test
    void testIntegerToRoman2() {
        assertEquals("IV", new Solution().intToRoman(4));
    }

    @Test
    void testIntegerToRoman3() {
        assertEquals("IX", new Solution().intToRoman(9));
    }

    @Test
    void testIntegerToRoman4() {
        assertEquals("LVIII", new Solution().intToRoman(58));
    }

    @Test
    void testIntegerToRoman5() {
        assertEquals("MCMXCIV", new Solution().intToRoman(1994));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void testRomanConversion(int value, String roman) {
        assertEquals(roman, new Solution().intToRoman(value));
    }

    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(9, "IX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(859, "DCCCLIX"),
                Arguments.of(900, "CM"),
                Arguments.of(4000, "MMMM")
        );
    }

}