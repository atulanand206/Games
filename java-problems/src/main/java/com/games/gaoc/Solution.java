package com.games.gaoc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        day8();
    }

    private static void day8() throws IOException {
        O.attach();
        int res = 0;
        Scanner sc = new Scanner(I.inputStream());
        while (sc.hasNextLine()) {
            String[] pre = new String[10];
            String[] test = new String[4];
            for (int i = 0; i < pre.length; i++)
                pre[i] = sc.next();
            sc.next();
            for (int i = 0; i < test.length; i++)
                test[i] = sc.next();
            Arrays.sort(pre, (a, b) -> Integer.compare(a.length(), b.length()));
            for (int i = 0; i < pre.length; i++) {
                String[] x = pre[i].split("");
                Arrays.sort(x);
                pre[i] = Arrays.stream(x).collect(Collectors.joining());
            }
            for (int i = 0; i < test.length; i++) {
                String[] x = test[i].split("");
                Arrays.sort(x);
                test[i] = Arrays.stream(x).collect(Collectors.joining());
            }
            List<Set<String>> testConf = new ArrayList<>();
            for (char[] elem : config)
                testConf.add(new TreeSet<>());
            String[] firstTwo = pre[0].split("");
            for (String ss : firstTwo) {
                testConf.get(0).add(ss);
                testConf.get(1).add(ss);
                testConf.get(3).add(ss);
                testConf.get(4).add(ss);
                testConf.get(7).add(ss);
                testConf.get(8).add(ss);
                testConf.get(9).add(ss);
            }
            String a = pre[1];
            for (String ss : firstTwo)
                a = a.replace(ss, "");
            for (int i = 0; i <= 9; i++)
                if (i == 1 || i == 4)
                    continue;
                else
                    testConf.get(i).add(a);
            String four = pre[2];
            for (String ss : firstTwo)
                four = four.replace(ss, "");
            String seven = pre[9];
            for (String ss : seven.split(""))
                testConf.get(8).add(ss);
            int six = -1;
            for (int i = 6; i <= 8; i++)
                if (!containsAll(pre[i], testConf.get(1))) {
                    six = i;
                    for (String sss : pre[i].split(""))
                        testConf.get(6).add(sss);
                }
            String c = seven;
            for (String ss : testConf.get(6))
                c = c.replace(ss, "");
            for (int i = 0; i <= 9; i++)
                if (i == 5 || i == 6)
                    continue;
                else
                    testConf.get(i).add(c);
            String f = pre[0].replace(c, "");
            for (int i = 3; i <= 5; i++) {
                if (containsAll(pre[i], testConf.get(1))) {
                    for (String sss : pre[i].split(""))
                        testConf.get(3).add(sss);
                }
                else if (!pre[i].contains(c)) {
                    for (String sss : pre[i].split(""))
                        testConf.get(5).add(sss);
                } else {
                    for (String sss : pre[i].split(""))
                        testConf.get(2).add(sss);
                }
            }
            for (String sss : pre[2].split(""))
                testConf.get(4).add(sss);
            Set<String> de = new HashSet<>(testConf.get(2));
            for (String ch : testConf.get(3)) de.remove(ch);
            String e = de.iterator().next();
          

            Set<String> de3 = new HashSet<>(testConf.get(8));
            for (String ch : pre[6].split("")) de3.remove(ch);

            for (String ss : de3) testConf.get(9).add(ss);
            int nine = -1;
            for (int i = 6; i <= 8; i++)
                if (i != six) {
                    if (pre[i].contains(e)) {
                        nine = i;
                    }
                }
            Set<Integer> x = new HashSet<>();
            for (int i = 6; i <= 8; i++) x.add(i);
            x.remove(six);
            x.remove(nine);
            int one = x.iterator().next();
            testConf.get(0).clear();
            for (String sss : pre[nine].split(""))
                testConf.get(0).add(sss);
            testConf.get(9).clear();
            for (String sss : pre[one].split(""))
                testConf.get(9).add(sss);
            List<String> conf = testConf.stream().map(row -> row.stream().collect(Collectors.joining())).collect(Collectors.toList());
            int nums = Arrays.stream(test)
                .map(o -> conf.indexOf(o))
                .reduce(0, (q, b) -> q * 10 + b);
            O.debug(S.string(nums));
            res += nums;
        }
        O.debug(S.string(res));
    }

    private static void day82() throws IOException {
        O.attach();
        int res = 0;
        Scanner sc = new Scanner(I.inputStream());
        while (sc.hasNextLine()) {
            String[] pre = new String[10];
            String[] test = new String[4];
            for (int i = 0; i < pre.length; i++)
                pre[i] = sc.next();
            sc.next();
            for (int i = 0; i < test.length; i++)
                test[i] = sc.next();
            
            for (int i = 0; i < test.length; i++) {
                String[] x = test[i].split("");
                Arrays.sort(x);
                test[i] = Arrays.stream(x).collect(Collectors.joining());
            }
            int nums = (int) Arrays.stream(test)
                .map(ox -> ox.length())
                .map(ox -> {
                    if (ox == 3) return 7;
                    if (ox == 2) return 1;
                    if (ox == 4) return 4;
                    if (ox == 7) return 8;
                    return 9;
                })
                .filter(ox -> ox != 9)
                .count();
            O.debug(S.string(test));
            O.debug(S.string(nums));
            res += nums;
        }
        O.debug(S.string(res));
    }

    private static boolean containsAll(String str, Set<String> t) {
        for (String ss : t)
            if (!str.contains(ss))
                return false;
        return true;
    }

    // a, c, f

    // d, c, e - a, b, c

    private static char[][] config = new char[][] {
            { 'a', 'b', 'c', 'e', 'f', 'g' },
            { 'c', 'f' },
            { 'a', 'c', 'd', 'e', 'g' },
            { 'a', 'c', 'd', 'f', 'g' },
            { 'b', 'c', 'd', 'f' },
            { 'a', 'b', 'd', 'f', 'g' },
            { 'a', 'b', 'd', 'e', 'f', 'g' },
            { 'a', 'c', 'f' },
            { 'a', 'b', 'c', 'd', 'e', 'f', 'g' },
            { 'a', 'b', 'c', 'd', 'f', 'g' },
    };

    // d, e

    private static void day7() throws IOException {
        O.attach();
        Scanner sc = new Scanner(I.inputStream());
        int[] arr = I.inputIntArray(sc);
        List<Integer> lst = new ArrayList<>();
        for (int i : arr)
            lst.add(i);
        int min = Collections.min(lst);
        int max = Collections.max(lst);
        int res = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            final int fI = i;
            int k = lst.stream().map(n -> (Math.abs(n - fI) * (Math.abs(n - fI) + 1)) / 2).reduce(0, (a, b) -> a + b);
            res = Math.min(k, res);
        }
        System.out.println(min + " " + max + " " + res);
    }

    private static void day61() throws IOException {
        O.attach();
        Map<Integer, Long> map = new HashMap<>();
        Scanner sc = new Scanner(I.inputStream());
        int[] arr = I.inputIntArray(sc);
        for (int i : arr)
            map.merge(i, 1L, Long::sum);
        int x = 256;
        for (int i = 1; i <= x; i++) {
            long k = map.getOrDefault(0, 0L);
            for (int j = 1; j <= 8; j++)
                map.put(j - 1, map.getOrDefault(j, 0L));
            map.merge(6, k, Long::sum);
            map.put(8, k);
        }
        System.out.println(map);
        System.out.println(map.values().stream().reduce(0L, (a, b) -> a + b));
    }

    private static void day41() throws IOException {
        try (Scanner br = new Scanner(I.inputStream())) {
            O.attach();
            List<int[]> starts = new ArrayList<>();
            List<int[]> ends = new ArrayList<>();
            while (br.hasNext()) {
                String[] x = br.nextLine().split(" -> ");
                starts.add(points(x[0]));
                ends.add(points(x[1]));
            }
            // starts.forEach(x -> O.debug(Arrays.toString(x)));
            // O.debugNewLine();
            // ends.forEach(x -> O.debug(Arrays.toString(x)));
            // O.debugNewLine();
            int x = max(starts, ends) + 1;
            int[][] mat = new int[x][x];
            for (int i = 0; i < starts.size(); i++) {
                int sX = starts.get(i)[0];
                int sY = starts.get(i)[1];
                int eY = ends.get(i)[1];
                int eX = ends.get(i)[0];
                if (sX == eX) {
                    int diff = sY - eY;
                    if (diff < 0) {
                        for (int j = sY; j <= eY; j++)
                            mat[j][sX]++;
                    } else {
                        for (int j = eY; j <= sY; j++)
                            mat[j][sX]++;
                    }
                } else if (sY == eY) {
                    int diff = sX - eX;
                    if (diff < 0) {
                        for (int j = sX; j <= eX; j++)
                            mat[sY][j]++;
                    } else {
                        for (int j = eX; j <= sX; j++)
                            mat[sY][j]++;
                    }
                } else if (Math.abs(sX - eX) == Math.abs(sY - eY)) {
                    // O.debug(S.string(String.format("(%d %d) (%d %d)", sX, sY, eX, eY)));
                    // O.debug(S.string(mat));
                    int xDiff = sX - eX < 0 ? 1 : -1;
                    int yDiff = sY - eY < 0 ? 1 : -1;
                    int pX = sX, pY = sY;
                    // O.debug(S.string(String.format("(%d %d) (%d %d)", pX, pY, xDiff, yDiff)));
                    mat[pY][pX]++;
                    while (pX >= 0 && pY >= 0 && pX < x - 1 && pY < x - 1) {
                        pX += xDiff;
                        pY += yDiff;
                        // O.debug(S.string(String.format("(%d %d) (%d %d)", pX, pY, xDiff, yDiff)));
                        if (pX == eX || pY == eY) {
                            mat[pY][pX]++;
                            break;
                        }
                        mat[pY][pX]++;
                    }
                    // O.debug(S.string(mat));
                    // O.debugNewLine();
                }
            }
            int res = 0;
            for (int[] row : mat)
                for (int i : row)
                    if (i >= 2)
                        res++;
            // O.debug(S.string(mat));
            O.debug(S.string(res));
        }
    }

    private static int max(List<int[]> starts, List<int[]> ends) {
        int x = 0;
        for (int[] pt : starts)
            for (int i : pt)
                x = Math.max(x, i);
        for (int[] pt : ends)
            for (int i : pt)
                x = Math.max(x, i);
        return x;
    }

    private static int[] points(String x) {
        String[] s = x.split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < 2; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }

    private static void print(List<int[][]> boards) {
        for (int[][] board : boards) {
            for (int[] row : board) {
                O.debug(Arrays.toString(row));
                O.debugNewLine();
                ;
            }
            O.debugNewLine();
            ;
        }
    }

    private static void day32() throws IOException {
        try (Scanner br = new Scanner(I.inputStream())) {
            O.attach();
            List<String> strings = new ArrayList<>();
            while (br.hasNext()) {
                strings.add(br.next());
            }
            strings.sort(Comparator.reverseOrder());
            int k = 0;
            int len = strings.get(0).length();
            O.debug(strings.size());
            O.debugNewLine();
            List<String> oxygen = new ArrayList<>(strings);
            for (k = 0; k < len && oxygen.size() > 1; k++) {
                final int fK = k;
                int onesCount = findOnes(oxygen, fK);
                char mostCommon = 2 * onesCount < oxygen.size() ? '0' : '1';
                oxygen = filterListWithKthBit(oxygen, fK, mostCommon);
                O.debug(oxygen.toString());
                O.debugNewLine();
            }
            List<String> co2 = new ArrayList<>(strings);
            for (k = 0; k < len && co2.size() > 1; k++) {
                final int fK = k;
                int onesCount = findOnes(co2, fK);
                char leastCommon = 2 * onesCount < co2.size() ? '1' : '0';
                co2 = filterListWithKthBit(co2, fK, leastCommon);
                O.debug(co2.toString());
                O.debugNewLine();
            }
            long ox = value(oxygen.get(0));
            long co = value(co2.get(0));
            long prod = (long) ox * (long) co;
            O.debug(ox);
            O.debugNewLine();
            O.debug(co);
            O.debugNewLine();
            O.print(prod);
        }
    }

    private static Long value(String str) {
        O.debug(Arrays.toString(str.split("")));
        return Arrays.stream(str.split(""))
                .mapToLong(x -> Long.parseLong(x))
                .reduce(0, (a, b) -> a * 2 + b);
    }

    private static List<String> filterListWithKthBit(List<String> oxygen, final int fK, char mostCommon) {
        return oxygen.stream()
                .filter(str -> str.charAt(fK) == mostCommon)
                .sorted()
                .collect(Collectors.toList());
    }

    private static int findOnes(List<String> co2, final int fK) {
        return (int) co2.stream()
                .filter(str -> str.charAt(fK) == '1')
                .count();
    }

    private static void day31() throws IOException {
        try (Scanner br = new Scanner(I.inputStream())) {
            O.attach();
            String entry = br.next();
            int[] bits = new int[entry.length()];
            while (br.hasNext()) {
                entry = br.next();
                for (int i = 0; i < entry.length(); i++)
                    bits[i] += entry.charAt(i) == '1' ? 1 : -1;
            }
            O.debug(Arrays.toString(bits));
            int gamma = Arrays.stream(bits)
                    .boxed()
                    .map(x -> x > 0 ? 1 : 0)
                    .reduce(0, (a, b) -> a * 2 + b);
            int epsilon = Arrays.stream(bits)
                    .boxed()
                    .map(x -> x < 0 ? 1 : 0)
                    .reduce(0, (a, b) -> a * 2 + b);
            long product = (long) gamma * (long) epsilon;
            O.print(product);
        }
    }

    private static long day22() throws IOException {
        Scanner br = new Scanner(I.inputStream());
        O.attach();
        int x = 0;
        int aim = 0;
        int depth = 0;
        while (br.hasNext()) {
            String type = br.next();
            int val = br.nextInt();
            switch (type) {
                case "forward":
                    x += val;
                    depth += aim * val;
                    break;
                case "up":
                    aim -= val;
                    break;
                case "down":
                    aim += val;
                    break;
            }
        }
        return (long) x * (long) depth;
    }

    public static class S {

        public static <T> String string(T val) {
            return val + "\n";
        }

        public static String string(int[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (int in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (long in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (double in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(boolean[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (boolean in : array)
                sb.append(in ? "T" : "F").append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (char in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[] array) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (String in : array)
                sb.append(in).append(", ");
            if (array.length != 0)
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(int[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(long[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (long[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(double[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (double[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string(boolean[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (boolean[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(char[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (char[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static String string(String[][] array) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (String[] in : array)
                sb.append("  ").append(string(in));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String stringi(List<T> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++)
                sb.append(i).append(": ").append(list.get(i)).append("\n");
            return sb.toString();
        }

        public static <T> String string(Collection<T> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracket(sb);
            for (T t : collection)
                sb.append(t).append(", ");
            if (!collection.isEmpty())
                deleteLastComma(sb);
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2D(Collection<Collection<T>> collection) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (Collection<T> t : collection)
                sb.append("  ").append(string(t));
            closingBracket(sb);
            return sb.toString();
        }

        public static <T> String string2Di(List<Collection<T>> list) {
            StringBuilder sb = new StringBuilder();
            openingBracketWithNewLine(sb);
            for (int i = 0; i < list.size(); i++)
                sb.append("  ").append(i).append(": ").append(string(list.get(i)));
            closingBracket(sb);
            return sb.toString();
        }

        public static <E, V> String string(Map<E, V> map) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<E, V> entry : map.entrySet())
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            sb.append("\n");
            return sb.toString();
        }

        private static void openingBracket(StringBuilder sb) {
            sb.append("[");
        }

        private static void openingBracketWithNewLine(StringBuilder sb) {
            sb.append("[\n");
        }

        private static void closingBracket(StringBuilder sb) {
            sb.append("]\n");
        }

        private static void deleteLastComma(StringBuilder sb) {
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    public static class I {

        public static int inputInt(BufferedReader br) throws IOException {
            return Integer.parseInt(br.readLine());
        }

        public static int[] inputIntArray(Scanner br) throws IOException {
            String[] spec = br.nextLine().split(",");
            int[] arr = new int[spec.length];
            for (int i = 0; i < spec.length; i++)
                arr[i] = Integer.parseInt(spec[i]);
            return arr;
        }

        public static int[] inputIntArray(BufferedReader br) throws IOException {
            String[] spec = br.readLine().split(" ");
            int[] arr = new int[spec.length];
            for (int i = 0; i < spec.length; i++)
                arr[i] = Integer.parseInt(spec[i]);
            return arr;
        }

        public static long inputLong(BufferedReader br) throws IOException {
            return Long.parseLong(br.readLine());
        }

        public static long[] inputLongArray(BufferedReader br) throws IOException {
            String[] spec = br.readLine().split(" ");
            long[] arr = new long[spec.length];
            for (int i = 0; i < spec.length; i++)
                arr[i] = Long.parseLong(spec[i]);
            return arr;
        }

        public static String inputString(BufferedReader br) throws IOException {
            return br.readLine();
        }

        public static String[] inputStringArray(BufferedReader br) throws IOException {
            return br.readLine().split(" ");
        }

        private static InputStreamReader inputStream() throws IOException {
            return ("why in the world not?".equals(System.getenv("LOCAL_CODING")))
                    ? fileInputStream()
                    : stdInputStream();
        }

        private static InputStreamReader stdInputStream() {
            return new InputStreamReader(System.in);
        }

        private static InputStreamReader fileInputStream() throws FileNotFoundException {
            return new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        }
    }

    public static class O {

        public static void attach() {
            debug("", false);
        }

        public static void debugNewLine() {
            debug("\n");
        }

        public static void debug(int val) {
            debug(String.valueOf(val));
        }

        public static void debug(long val) {
            debug(String.valueOf(val));
        }

        public static void debug(boolean val) {
            debug(val ? "T" : "F");
        }

        public static void debug(String text) {
            debug(text, true);
        }

        public static void debug(String text, boolean append) {
            if (!"why in the world not?".equals(System.getenv("LOCAL_CODING")))
                return;
            try {
                FileWriter fileWriter = new FileWriter("debug.txt", append);
                fileWriter.write(text);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static <T> void print(T object) {
            System.out.println(object);
        }
    }
}
