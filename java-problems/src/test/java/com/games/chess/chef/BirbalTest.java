package com.games.chess.chef;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.games.chess.utils.ListUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirbalTest {

    interface S {
        void a();
    }

    abstract class d implements S {

    }

    class a implements S {

        public void a() {

        }
    }


    private int asd(int a, int b) {
        return a+b;
    }
    @Test
    void  fasd() {

        try {
            Float f = new Float("3.0");
            int x = f.intValue();
            byte b = f.byteValue();
            double d = f.doubleValue();
            System.out.println(x + b +d);
        } catch (NumberFormatException e) {
            System.out.println("bad");
        }
    }

    class SampleDemo implements Runnable {
        private Thread t;
        private String threadName;

        SampleDemo(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            while (true) {
                System.out.println(threadName);
            }
        }

        public void start() {
            if (t==null) {
                t= new Thread(this, threadName);
                t.start();
            }
        }
    }

    @Test
    void sa() {
        SampleDemo A = new SampleDemo("A");
        SampleDemo B = new SampleDemo("B");
        B.start();
        A.start();
    }

    @Test
    void testCandleCuts() {
        assertEquals(2, Birbal.cuts(new ArrayList<>(listOf(5, 3, 5))));
        assertEquals(3, Birbal.cuts(new ArrayList<>(listOf(1, 2, 3))));
        assertEquals(3, Birbal.cuts(new ArrayList<>(listOf(4, 2, 3, 4))));
        assertEquals(6, Birbal.cuts(new ArrayList<>(listOf(14, 12, 3, 44, 21, 42))));
    }

    // 14 12 3 44 21 42
    // 14 12 3 42 21 42
    // 14 12 3 21 21 21
    // 14 12 3 7 7 7
    // 12 12 3 7 7 7
    // 7 7 3 7 7 7
    // 3 3 3 3 3 3

    // 1 2 3 6 7 9 10 12
    // 1 2 3 6 7 9 10 10
    // 1 2 3 6 7 9 9 9
    // 1 2 3 6 7 7 7 7
    // 1 2 3 6 6
    // 1 2 3 3 3
    // 1 2 2 2
    // 1 1 1 1
    // 0

}
