package com.games.LeetCode.Problems.CourseSchedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCourseFinish() {
        assertTrue(new Solution().canFinish(2, new int[][]{{1,0}}));
    }

    @Test
    void testCourseFinish2() {
        assertFalse(new Solution().canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

    @Test
    void testCourseFinish3() {
        assertFalse(new Solution().canFinish(2, new int[][]{{1,0}, {0,2}, {2, 1}}));
    }

}