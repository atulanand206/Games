package com.games.LeetCode.Problems.TwoSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test1() {
        int[] ints = new Solution().twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}