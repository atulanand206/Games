package com.games.UVa.P111;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGrades1() {
        assertEquals(1, getScore("4 2 3 1", "1 3 2 4"));
    }

    @Test
    void testGrades2() {
        assertEquals(2, getScore("4 2 3 1", "3 2 1 4"));
    }

    @Test
    void testGrades3() {
        assertEquals(3, getScore("4 2 3 1", "2 3 4 1"));
    }

    @Test
    void testGrades4() {
        assertEquals(6, getScore("3 1 2 4 9 5 10 6 8 7", "1 2 3 4 5 6 7 8 9 10"));
    }

    @Test
    void testGrades5() {
        assertEquals(5, getScore("3 1 2 4 9 5 10 6 8 7", "4 7 2 3 10 6 9 1 5 8"));
    }

    @Test
    void testGrades6() {
        assertEquals(10, getScore("3 1 2 4 9 5 10 6 8 7", "3 1 2 4 9 5 10 6 8 7"));
    }

    @Test
    void testGrades7() {
        assertEquals(9, getScore("3 1 2 4 9 5 10 6 8 7", "2 10 1 3 8 4 9 5 7 6")); //2 4 9 5 7
    }

    private int getScore(String chron, String row) {
        return Main.score(chron.split(" "), row.split(" "));
    }

}