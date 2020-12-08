package com.games.HR.breakingTheRecords;

import org.junit.jupiter.api.Test;

import static com.games.Utils.assertSameArray;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testRecords() {
        assertSameArray(new int[]{2,4}, Solution.breakingRecords(new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1}));
    }

}