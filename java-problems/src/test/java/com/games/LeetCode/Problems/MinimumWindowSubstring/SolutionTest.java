package com.games.LeetCode.Problems.MinimumWindowSubstring;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testMinWindow() {
        assertEquals("BANC", new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testMinWindow2() {
        assertEquals("a", new Solution().minWindow("a", "a"));
    }

    @Test
    void testMinWindow3() {
        assertEquals("", new Solution().minWindow("a", "aa"));
    }

    @Test
    void testMinWindow4() {
        assertEquals("", new Solution().minWindow("a", "b"));
    }

    @Test
    void testMinWindow5() {
        assertEquals("", new Solution().minWindow("ab", "A"));
    }

    @Test
    void testMinWindow6() {
        assertEquals("aa", new Solution().minWindow("aa", "aa"));
    }

    @Test
    void testMinWindow7() {
        assertEquals("abc", new Solution().minWindow("abc", "cba"));
    }

    @Test
    void testIsMapValid() {
        Solution solution = new Solution();
        Map<Character, Integer> sMap = solution.getCharIntMap("a");
        Map<Character, Integer> tMap = solution.getCharIntMap("aa");
        assertNotSameMap(solution, sMap, tMap);
    }

    @Test
    void testIsMapValid2() {
        Solution solution = new Solution();
        Map<Character, Integer> sMap = solution.getCharIntMap("ab");
        Map<Character, Integer> tMap = solution.getCharIntMap("aa");
        assertNotSameMap(solution, sMap, tMap);
    }

    @Test
    void testIsMapValid3() {
        Solution solution = new Solution();
        Map<Character, Integer> sMap = solution.getCharIntMap("aba");
        Map<Character, Integer> tMap = solution.getCharIntMap("aa");
        assertSameMap(solution, sMap, tMap);
    }

    @Test
    void testIsMapValid4() {
        Solution solution = new Solution();
        Map<Character, Integer> sMap = solution.getCharIntMap("ab");
        Map<Character, Integer> tMap = solution.getCharIntMap("A");
        assertNotSameMap(solution, sMap, tMap);
    }

    @Test
    void testIsMapValid5() {
        Solution solution = new Solution();
        Map<Character, Integer> sMap = solution.getCharIntMap("aa");
        Map<Character, Integer> tMap = solution.getCharIntMap("aa");
        assertSameMap(solution, sMap, tMap);
    }

    @Test
    void testGetCharIntMap() {
        Map<Character, Integer> aa = new Solution().getCharIntMap("aa");
        System.out.println(printMap(aa));
    }

    @Test
    void testMapCase() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        assertTrue(map.containsKey('a'));
        assertFalse(map.containsKey('A'));
    }

    private void assertSameMap(Solution solution, Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        System.out.println(printMap(sMap));
        System.out.println(printMap(tMap));
        assertTrue(solution.isMapValid(sMap, tMap));
    }

    private void assertNotSameMap(Solution solution, Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        System.out.println(printMap(sMap));
        System.out.println(printMap(tMap));
        assertFalse(solution.isMapValid(sMap, tMap));
    }

    private String printMap(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}