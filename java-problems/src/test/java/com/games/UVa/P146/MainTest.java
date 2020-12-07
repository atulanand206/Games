package com.games.UVa.P146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testNextString() {
        assertEquals("ababac", Main.nextString("abaacb"));
    }

    @Test
    void testNextString2() {
        assertEquals("No Successor", Main.nextString("cbbaa"));
    }

    @Test
    void testNextString3() {
        assertEquals("ababacnjhjifsffaadl", Main.nextString("ababacnjhjifsfdlfaa"));
    }

    @Test
    void testNextString4() {
        assertEquals("ababacnjhjiasdfsa", Main.nextString("ababacnjhjiasdfas"));
    }

    @Test
    void testNextString5() {
        assertEquals("No Successor", Main.nextString("zyxwpojihgfcba"));
    }

    @Test
    void testSuccessorAvailable() {
        assertEquals(true, Main.successorAvailable('b', "cb"));
        assertEquals(true, Main.successorAvailable('a', "cb"));
        assertEquals(false, Main.successorAvailable('c', "cb"));
    }

    @Test
    void testChooseChar() {
        assertEquals('c', Main.chooseCharacter('b', "ac"));
        assertEquals('b', Main.chooseCharacter('a', "cbasd"));
        assertEquals('o', Main.chooseCharacter('l', "yuio"));
    }

    @Test
    void testSorted() {
        assertEquals("aaab", Main.sorted("abaa"));
    }
}