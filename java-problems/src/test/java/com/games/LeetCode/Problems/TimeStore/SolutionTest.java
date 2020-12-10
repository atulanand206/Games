package com.games.LeetCode.Problems.TimeStore;

import com.games.LeetCode.Problems.TimeStore.Solution.TimeMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testTimeStamp() {
        System.out.println(System.nanoTime());
    }

    @Test
    void testTimeMap() {
        TimeMap kv = new TimeMap();
        kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
        assertEquals("bar", kv.get("foo", 1));  // output "bar"
        assertEquals("bar", kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
        kv.set("foo", "bar2", 4);
        assertEquals("bar2", kv.get("foo", 4)); // output "bar2"
        assertEquals("bar2", kv.get("foo", 5)); //output "bar2"
    }

}