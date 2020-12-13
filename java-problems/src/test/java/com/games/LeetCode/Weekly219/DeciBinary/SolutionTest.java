package com.games.LeetCode.Weekly219.DeciBinary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testDeciBinary() {
        Solution solution = new Solution();
        assertEquals(3, solution.minPartitions("32"));
    }

    @Test
    void testDeciBinary1() {
        Solution solution = new Solution();
        assertEquals(8, solution.minPartitions("82734"));

    }

    @Test
    void testDeciBinary2() {
        Solution solution = new Solution();
        assertEquals(9, solution.minPartitions("27346209830709182346"));
    }

    @Test
    void test() {
        System.out.println(82734-11111);
        System.out.println(71623-11111);
        System.out.println(60512-10111);
        System.out.println(50401-10101);
        System.out.println(40300-10100);
        System.out.println(30200-10100);
        System.out.println("27346209830709182346".length());
        System.out.println("16235108720608071235".length());
        System.out.println("16235108720608060124".length());

    }


}