package com.games.HR.betweenTwoSets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testTwoSets() {
        assertEquals(3, Solution.getTotalX(Arrays.stream(new int[]{2, 4}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{16, 32, 96}).boxed().collect(Collectors.toList())));
    }

    @Test
    void testTwoSets2() {
        assertEquals(2, Solution.getTotalX(Arrays.stream(new int[]{2, 6}).boxed().collect(Collectors.toList()),
                Arrays.stream(new int[]{24, 36}).boxed().collect(Collectors.toList())));
    }

}