package com.games.LeetCode.Problems.OrderedStream;

import com.games.LeetCode.Problems.OrderedStream.Solution.OrderedStream;
import com.games.Utils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.games.Utils.assertSameList;

class SolutionTest {

    @Test
    void testOrderedStream() {
        OrderedStream os = new OrderedStream(5);
        assertSameList(List.of(), os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
        assertSameList(List.of("aaaaa"), os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        assertSameList(List.of("bbbbb", "ccccc"), os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        assertSameList(List.of(), os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
        assertSameList(List.of("ddddd", "eeeee"), os.insert(4, "ddddd"));
    }

}