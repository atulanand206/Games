package com.games.LeetCode.Contest.A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("asd")
    void testMax(String input, String output) {
        String mx = new Solution().max(input);
        System.out.printf("%s : %s\n", input, mx);
        Assertions.assertEquals(output, mx);
    }

    @ParameterizedTest
    @MethodSource("asd")
    void testMex(String input, String output) {
        long mx = new Solution().mex(input);
        String string = Long.toBinaryString(mx);
        System.out.printf("%s : %d : %s : %s\n", input, mx, string, string.length());
        Assertions.assertEquals(output, string);
    }

    private static Stream<Arguments> asd() {
        return Stream.of(
                // 1s < 0s => if last 1 => 1s + 0 else => 1s + 1 : OK
                Arguments.of("1001001", "1110"),
                Arguments.of("10001", "110"),
                Arguments.of("10010010", "1111"),
                Arguments.of("100101000", "1111"),

                // If after last 1 => more than 2 0s, ignore from 3rd. : OK
                Arguments.of("1001010111000000000", "110001"), // 1111111 : 3
                Arguments.of("10010101110000000", "110001"),
                Arguments.of("100101011100000", "110001"),
                Arguments.of("1001010111000", "110001"),

                // Max 0s(first) before last 1 : x at ix => 1s before ix : y => 1s(y+1) + 0s() + 1s()
                Arguments.of("100101011100", "110001"), // 11 > 110 > 111 > 1100 > 1101
                Arguments.of("101001011100", "111001"),
                Arguments.of("101010011100", "111101"),
                Arguments.of("100110011100", "110001"), // 1111111 : 3
                Arguments.of("100110101100", "110001"), // 1111111 : 3
                Arguments.of("101010011100", "111101"), //

                Arguments.of("100110111100", "11001"),
                Arguments.of("100110110110", "110000"),

                Arguments.of("1001111100", "1101"),
                Arguments.of("10111100", "1001"), // 111111 : 2

                Arguments.of("1010100110100", "1111001"),




                Arguments.of("10010101110", "110000"),

                Arguments.of("1001010111", "11000"),
                Arguments.of("10010101110", "110000"),

                Arguments.of("10101001", "11110"),

                Arguments.of("1011000", "1001"),
                Arguments.of("100100100", "1111"),
                Arguments.of("1010100", "1111"),
                Arguments.of("1001010111", "11000"),

                Arguments.of("1010101", "10000"),
                Arguments.of("10101", "1000"),
                Arguments.of("1101", "100"),
                Arguments.of("1001011", "1100"),
                Arguments.of("1011", "100"),
                Arguments.of("1010011", "1110"),
                Arguments.of("1011011", "1000"),
                Arguments.of("1011", "100"),

                Arguments.of("101010", "1111"),

                // Last 1 => 0s before last 1 => 1 and all the 0s;
                // If no 0s before last 1 => 101
                Arguments.of("1001110", "1100"),

                Arguments.of("0000", "1"),
                Arguments.of("1111", "0"),
                Arguments.of("11110", "100"),
                Arguments.of("111000", "101"),
                Arguments.of("11110000", "101"),
                Arguments.of("111100", "101")
        );
    }

    /*
        Last 1 => Right se 1st 1 (l1x).
        0s till last 1 => 0 to l1x => count 0s.
     */
    /* Observations
        If all 1s => 0; If all 0s => 1 : OK
        If all 1s before all 0s => If 0s == 1 => 100 Else => 101 :OK
        If 0s before last 1 => 1 + count 0s + 0
        If 1s < 0s =>
            If 0s after last 1 => 1(1s) + 1
            Else => 1(1s) + 0


     */
}