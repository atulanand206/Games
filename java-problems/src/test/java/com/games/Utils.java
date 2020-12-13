package com.games;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
    public static void assertSameArray(int[] a1, int[] a2) {
        assertEquals(a2.length, a1.length);
        for (int i = 0; i < a1.length; i++)
            assertEquals(a1[i], a2[i]);
    }

    public static <T> void assertSameList(List<T> a1, List<T> a2) {
        assertEquals(a2.size(), a1.size());
        for (int i = 0; i < a1.size(); i++)
            assertEquals(a1.get(i), a2.get(i));
    }

    public static <T> void assertSame2DList(List<List<T>> l1, List<List<T>> l2) {
        assertEquals(l1.size(), l2.size());
        for (int i = 0; i < l1.size(); i++)
            assertSameList(l1.get(i), l2.get(i));
    }
}
