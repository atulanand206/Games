package com.games.UVa.P102;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testBinPacking() {
        assertEquals("BCG 30", new Main().binPacking("1 2 3 4 5 6 7 8 9".split(" ")));
        assertEquals("CBG 50", new Main().binPacking("5 10 5 20 10 5 10 20 10".split(" ")));
    }

}