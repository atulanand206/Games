package com.games.chess.chef;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.games.chess.utils.ListUtils.*;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeaderBoardTest {

    @Test
    void nothing() {
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listOf(6, 5, 4, 2, 1), toLis(climbingLeaderboard(new int[]{100, 90, 90, 80, 75, 60}, new int[]{50, 65, 77, 90, 102}))));
    }

    static List<Integer> toLis(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int arr : array)
            list.add(arr);
        return list;
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Set<Integer> scoresWithoutDuplicates = new TreeSet<>(Collections.reverseOrder());
        for (int sc : scores)
            scoresWithoutDuplicates.add(sc);
        int[] resultArray = new int[alice.length];
        List<Integer> items = new ArrayList<>(scoresWithoutDuplicates);
        print(items);
        print(alice);
        int resultArrayIndex = 0;
        int scoreToFit = alice[resultArrayIndex];
        for (int i = 0; i < alice.length; i++) {
            System.out.println(items.get(i));
            System.out.println(i);
//            if (scoreToFit)
//            if (alice[i]>items.get(i)) {
//                resultArray[i] =
//            }
//            if (items.get(i - 1) >= alice[resultArrayIndex])
//                resultArray[resultArrayIndex] = i ;
            resultArrayIndex++;
        }
        print(resultArray);
        return resultArray;
    }
}
