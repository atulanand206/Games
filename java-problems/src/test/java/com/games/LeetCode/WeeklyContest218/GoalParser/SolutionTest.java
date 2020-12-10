package com.games.LeetCode.WeeklyContest218.GoalParser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCommand() {
        assertEquals("Goal", new Solution().interpret("G()(al)"));
    }

    @Test
    void testCommand2() {
        assertEquals("Gooooal", new Solution().interpret("G()()()()(al)"));
    }

    @Test
    void testCommand3() {
        assertEquals("alGalooG", new Solution().interpret("(al)G(al)()()G"));
    }

}