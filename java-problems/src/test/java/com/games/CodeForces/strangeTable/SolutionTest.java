package com.games.CodeForces.strangeTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testStrange() {
        assertEquals(1, new Solution().rowsFromColumns(1, 1, 1));
        assertEquals(2, new Solution().rowsFromColumns(2, 2, 3));
        assertEquals(9, new Solution().rowsFromColumns(3, 5, 11));
        assertEquals(1174, new Solution().rowsFromColumns(100, 100, 7312));
        assertEquals(1000000000000L, new Solution().rowsFromColumns(1000000, 1000000, 1000000000000L));
    }

    @Test
    void testCoords() {
        new Solution().rowsFromColumns(3, 5, 8);
        new Solution().rowsFromColumns(3, 5, 14);
        new Solution().rowsFromColumns(3, 5, 12);
        new Solution().rowsFromColumns(3, 5, 13);
    }
}