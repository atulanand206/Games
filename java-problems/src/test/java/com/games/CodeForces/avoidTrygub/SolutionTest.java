package com.games.CodeForces.avoidTrygub;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testTrygub() {
        String string = "antontrygub";
        String reordered = Solution.reordered(string);
        assertTrue(Solution.isSubSequence(string));
        assertTrue(!Solution.isSubSequence(reordered));
        assertSameCharacters(string, reordered);
    }

    @Test
    void testTrygub2() {
        String string = "bestcoordinator";
        String reordered = Solution.reordered(string);
        assertTrue(!Solution.isSubSequence(string));
        assertTrue(!Solution.isSubSequence(reordered));
        assertSameCharacters(string, reordered);
    }

    @Test
    void testTrygub3() {
        String string = "trywatchinggurabruh";
        String reordered = Solution.reordered(string);
        assertTrue(Solution.isSubSequence(string));
        assertTrue(!Solution.isSubSequence(reordered));
        assertSameCharacters(string, reordered);
    }

    @Test
    void testIsSubSequence() {
        String string = "trywatchinggurabruh";
        assertTrue(Solution.isSubSequence(string));
    }

    @Test
    void testJoinString() {
        int[] count = new int[]{2, 3, 1, 2, 2, 1};
        char[] chars = {'h', 'e', 'l', 'l', 'o', 'x', 'o', 'c', 'e'};
        List<Character> characters = IntStream
                .range(0, chars.length)
                .mapToObj(i -> chars[i])
                .collect(Collectors.toList());
        assertEquals("buuggyrrrtthelloxoce", Solution.joinString(count, characters));
    }

    private void assertSameCharacters(final String str1, final String str2) {
        char[] cha1 = str1.toCharArray();
        char[] cha2 = str2.toCharArray();
        Arrays.sort(cha1);
        Arrays.sort(cha2);
        assertEquals(cha1.length, cha2.length);
        for (int i = 0; i < str1.length(); i++)
            assertEquals(cha1[i], cha2[i]);
    }
}