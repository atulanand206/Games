package com.games.chess.primes;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsTest {

    private List<Integer> listOf(Integer... ints) {
        Integer[] integers = new Integer[ints.length];
        System.arraycopy(ints, 0, integers, 0, ints.length);
        return Arrays.asList(integers);
    }

    @Test
    void factors() throws Exception {
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(2), listOf(2)));
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(3), listOf(3)));
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(9), listOf(3, 3)));
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(3 * 3 * 5 * 7 * 11), listOf(3, 3, 5, 7, 11)));
    }

    private List<Integer> primesOf(int i) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int div = 2; i > 1; div++)
            for (; i % div == 0; i /= div)
                integers.add(div);
        return integers;
    }
}
