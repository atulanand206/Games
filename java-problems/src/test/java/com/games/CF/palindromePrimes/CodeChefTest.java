package com.games.CF.palindromePrimes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.games.CF.palindromePrimes.CodeChef.*;
import static org.junit.jupiter.api.Assertions.*;

class CodeChefTest {

    @Test
    void testMaxFromDigits() {
        assertEquals("99321", maxFromDigits("19329"));
        assertEquals("9876543210", maxFromDigits("1203457689"));
        assertEquals("97732", maxFromDigits("72973"));
    }

    @Test
    void testSieve() {
        printSieve(sieveOfEratosthenes(100));
        printSieve(sieveOfEratosthenes(10));
        printSieve(sieveOfEratosthenes(1000000));
    }

    private void printSieve(boolean[] booleans) {
        for (int i = 0; i < booleans.length; i++) if (booleans[i]) System.out.printf("%d ", i);
        System.out.println();
    }

    @Test
    void testSieveList() {
        assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ",
                listString(primes(sieveOfEratosthenes(100))));
    }

    private String listString(List<Integer> ints) {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) sb.append(i).append(" ");
        return sb.toString();
    }

    @Test
    void testSegmentedSieve() {
        assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ",
                listString(segmentedSieve(100)));
        System.out.println(listString(segmentedSieve(1000000)));
    }
}