package com.games.chess.primes;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.games.chess.utils.ListUtils.listOf;
import static com.games.chess.utils.ListUtils.print;

public class Primes {

    @Test
    void test() {
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(2), listOf(2)));
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(3), listOf(3)));
        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(4), listOf(2,2)));
//        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(25), listOf(5, 5)));
//        Assertions.assertTrue(CollectionUtils.isEqualCollection(primesOf(64), listOf(2,2,2,2,2,2)));

    }

    private List<Integer> primesOf(int num) {
        List<Integer> primes = new ArrayList<>();
        primes.add(num);
        print(primes);
        return primes;
    }
}
