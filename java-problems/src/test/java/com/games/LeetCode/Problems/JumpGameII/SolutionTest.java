package com.games.LeetCode.Problems.JumpGameII;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertEquals(2, new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().jump(new int[]{2, 3, 0, 1, 4}));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
    }

    @Test
    void test4() {
        assertEquals(3, new Solution().jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

//    @ParameterizedTest
//    @MethodSource("asdf")
//    void testJump(int[] input, int output) {
//        assertEquals(output, new Solution().jump(input));
//    }
//
//    private static Stream<Arguments> asdf() {
//        return Stream.of(
//                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
//                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2),
//                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}, 2)
//        );
//    }

}