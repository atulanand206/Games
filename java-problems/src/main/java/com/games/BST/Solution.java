package com.games.BST;

import com.games.chess.utils.ListUtils;

import java.util.*;
import java.util.Arrays;

public class Solution {

    static class Cake {
        // Split string is same segments. Max segment count.

        private static boolean isValid(String x, int s) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= x.length() - s; i += s) {
                set.add(x.substring(i, i + s));
            }
            return set.size() == 1;
        }

        private static List<Integer> factors(int n) {
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= n / 2; i++) if (n % i == 0) factors.add(i);
            factors.add(n);
            return factors;
        }

        public static int solution(String x) {
            for (int i : factors(x.length()))
                if (isValid(x, i)) return x.length() / i;
            return 1;
        }
    }

    static class Gear {
        // Algebraic equation. R1 = 2Rn. Ri >= 1.ls

        public static int[] solution(int[] pegs) {
            int res = pegs[pegs.length - 1];
            boolean neg = true;
            for (int i = pegs.length - 2; i > 0; i--) {
                res += (neg ? -1 : 1) * 2 * pegs[i];
                neg = !neg;
            }
            res += (neg ? -1 : 1) * pegs[0];
            int n, d = 1;
            if (pegs.length % 2 != 0) n = -2 * res;
            else {
                n = 2 * res;
                d = 3;
            }
            if (d == 3 && n % 3 == 0) {
                n = n / 3;
                d = 1;
            }
            double k = n / d;
            double v = k;
            if (v < 2) return new int[]{-1, -1};
            for (int i = 1; i < pegs.length; i++) {
                v = pegs[i] - pegs[i - 1] - v;
                if (v < 1) return new int[]{-1, -1};
            }
            if (k >= 2) return new int[]{n, d};
            return new int[]{-1, -1};
        }
    }

    static class Ion {
        // Parent element in full binary tree with postorder sorted 1..N.

        private static int ancestor(int v, int l, int k) {
            if (l == 1) return v;
            int va = v - (int) Math.pow(2, l);
            if (k == va || k == v - 1) return v;
            if (k < va) return ancestor(va, l - 1, k);
            return ancestor(v - 1, l - 1, k);
        }

        public static int[] solution(int height, int[] cases) {
            int[] results = new int[cases.length];
            int max = (int) (Math.pow(2, height + 1)) - 1;
            System.out.println(max);
            for (int i = 0; i < cases.length; i++) {
                if (cases[i] == Math.pow(2, height) - 1)
                    results[i] = -1;
                else
                    results[i] = ancestor(max, height, cases[i]);
            }
            return results;
        }
    }

    static class Checksum {
        // Avoiding certain values for XOR. XOR Reduuction.

        private static int xor(int n) {
            int mod = n % 4;
            if (mod == 0) return n;
            if (mod == 1) return 1;
            if (mod == 2) return n + 1;
            if (mod == 3) return 0;
            return 0;
        }

        public static int solution(int id, int len) {
            int res = 0;
            int l = id, r = id + len - 1;
            if (l == 0) res ^= xor(r);
            else res ^= xor(l - 1) ^ xor(r);
            int it = len - 1;
            System.out.println(l + " " + r);
            while (l != r) {
                it--;
                l = l + len;
                r = l + it;
                System.out.println(l + " " + r);
                res ^= xor(l - 1) ^ xor(r);
            }
            return res;
        }
    }

    static class Triplets {
        // Count lucky triples
        // brute force fails

        static int[] allowed = new int[]{320, 360, 400};
        static Set<Integer> aset = new HashSet<>();

        static void printMid(Set<List<Integer>> set) {
            List<List<Integer>> list = new ArrayList<>(set);
            list.sort(Comparator.comparing(l -> l.get(1)));
            List<List<List<Integer>>> n = new ArrayList<>();
            int val = 0, i = 0;
            List<List<Integer>> l = new ArrayList<>();
            for (List<Integer> in : list) {
                if (in.get(1) != val) {
                    n.add(l);
                    l = new ArrayList<>();
                }
                val = in.get(1);
                l.add(in);
            }
            n.add(l);
            for (List<List<Integer>> v : n) {
                if (v.isEmpty()) continue;
                if (aset.contains(v.get(0).get(1))) {
                    System.out.printf("%d: %d: ", v.get(0).get(1), v.size());
                    for (List<Integer> y : v) {
                        System.out.print(y + ", ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();
        }

        private static void print(int[] l, long cnt, int i, long prevCnt, Set<Integer> fs, Set<Integer> ms) {
            if (cnt - prevCnt != 0) {
                System.out.printf("%d: ", l[i]);
                System.out.printf("%d: ", cnt - prevCnt);
                System.out.print("fac ");
                printSet(fs);
                System.out.print("mult ");
                printSet(ms);
                System.out.println();
            }
        }

        static void printSet(Set<Integer> set) {
            for (int i : set) System.out.printf("%d, ", i);
        }

        static int bruteForce(int[] l) {
            Arrays.sort(l);
            Set<List<Integer>> log = new HashSet<>();
            for (int i = 0; i < l.length; i++)
                for (int j = i + 1; j < l.length; j++)
                    if (l[j] % l[i] == 0)
                        for (int k = j + 1; k < l.length; k++)
                            if (l[k] % l[j] == 0)
                                log.add(Arrays.asList(l[i], l[j], l[k]));
            printMid(log);
            return log.size();
        }

        private static boolean isMatch(int[] l) {
            System.out.println();
            ListUtils.print(l);
            long r = solution(l);
            int b = sol(l);
            System.out.printf("R- %d B- %d ", r, b);
            return r == b;
        }

        private static int sol(int[] l) {
            int count = 0;
            int size = l.length;
            if (size < 3) return 0;
            int[] cache = new int[size];
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++)
                    if (l[j] % l[i] == 0) {
                        cache[j] += 1;
                        count += cache[i];
                    }
            }
            return count;
        }

        private static Set<Integer> factors(int[] l, int n) {
            Set<Integer> handled = new TreeSet<>();
            for (int i = 0; i < n; i++) if (l[n] % l[i] == 0) handled.add(l[i]);
            return handled;
        }

        private static Set<Integer> multiples(int[] l, int n) {
            Set<Integer> handled = new TreeSet<>();
            for (int i = n + 1; i < l.length; i++) if (l[i] % l[n] == 0) handled.add(l[i]);
            return handled;
        }

        private static int firstIndexOf(int[] l, int x) {
            for (int i = 0; i < l.length; i++)
                if (l[i] == x) return i;
            return -1;
        }

        private static Map<Integer, Integer> count(int[] l) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int aL : l) count.merge(aL, 1, Integer::sum);
            return count;
        }

        private static int solution(int[] l) {
            Arrays.sort(l);
            ListUtils.print(l);
            int cnt = 0;
            Map<Integer, Integer> count = count(l);
            Set<Integer> doubles = new HashSet<>();
            Set<Integer> skipped = new HashSet<>();
            Set<Integer> handled = new HashSet<>();
            for (int i = 0; i < l.length; i++) {
                int prevCnt = cnt;
                Set<Integer> fs = factors(l, i);
                Set<Integer> ms = multiples(l, i);
                int f = fs.size();
                int m = ms.size();
                if (count.get(l[i]) == 1) {
                    cnt += f * m;
                }
                if (count.get(l[i]) == 2) {
                    doubles.add(l[i]);
                }
                if (count.get(l[i]) > 2) {
                    if (skipped.contains(l[i]) && !handled.contains(l[i])) {
                        cnt += f * m;
                        handled.add(l[i]);
                    }
                    if (!skipped.contains(l[i]))
                        skipped.add(l[i]);
                }
//                print(l, cnt, i, prevCnt, fs, ms);
            }

            for (int val : doubles) {
                int prevCnt = cnt;
                int i = firstIndexOf(l, val);
                Set<Integer> fs = factors(l, i);
                Set<Integer> ms = multiples(l, i + 1);
                int f = fs.size();
                int m = ms.size();
                if (f != 0 && m != 0) cnt += (f + 1) * (m + 1) - 1;
                else if (f == 0 && m != 0) cnt += m;
                else if (f != 0) cnt += f;
//                print(l, cnt, i, prevCnt, fs, ms);
            }
            return cnt;
        }

    }

    public static void main(String[] args) {
//        System.out.println(Triplets.isMatch(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3}));
//        System.out.println(Triplets.isMatch(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(Triplets.isMatch(new int[]{1, 1, 1}));
//        System.out.println(Triplets.isMatch(new int[]{7, 1, 2, 15, 4, 4, 14, 11, 10, 16, 24, 1, 28, 13, 3, 6, 12, 15, 5, 11}));
//        System.out.println(Triplets.isMatch(new int[]{1, 2, 4, 8}));
//        System.out.println(Triplets.isMatch(new int[]{4, 5, 2, 8, 5, 9, 2, 2, 7, 1}));
//        System.out.println(Triplets.isMatch(new int[]{720, 220, 620, 770, 740, 620, 160, 970, 190, 550, 730, 340, 90, 170, 660, 940, 990, 250, 320, 930, 400, 50, 210, 640, 390, 830, 440, 760, 760, 550, 140, 150, 890, 610, 620, 340, 710, 590, 410, 480, 770, 830, 520, 400, 70, 770, 410, 240, 660, 210, 200, 280, 320, 760, 340, 360, 60, 660, 950, 30, 260, 230, 210, 420, 570, 20, 580, 480, 350, 360, 270, 180, 230, 690, 370, 80, 780, 510, 530, 800, 90, 640, 260, 230, 860, 690, 860, 420, 560, 690, 100, 420, 980, 700, 600, 680, 530, 10, 240, 930}));
        System.out.println(Triplets.isMatch(randomNumbers(100, 1000)));
        System.out.println(Triplets.isMatch(randomNumbers(2000, 999999)));
        System.out.println(Triplets.isMatch(randomNumbers(2000, 999999)));
        System.out.println(Triplets.isMatch(randomNumbers(2000, 999999)));
        System.out.println(Triplets.isMatch(randomNumbers(2000, 999999)));
        System.out.println(Triplets.isMatch(randomNumbers(100, 1000)));
    }

    private static int[] randomNumbers(int count, int limit) {
        int[] nums = new int[count];
        Random rand = new Random();
        for (int i = 0; i < count - 1; i++) {
            int random = random(rand, limit, rand.nextInt(20) + 1);
            nums[i++] = random;
            if (i < count)
                nums[i++] = random * 2;
            if (i < count)
                nums[i++] = random / 2;
            if (i < count)
                nums[i] = random;
        }
        return nums;
    }

    public static int random(Random random, int range, int multiple) {
        if (range < multiple) return 1;
        int value = random.nextInt(range / multiple) * multiple;
        return value == 0 ? 1 : value + 1;
    }
}
