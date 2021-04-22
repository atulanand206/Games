package com.games.BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.games.chess.utils.ListUtils.print;
import static com.games.chess.utils.ListUtils.print2D;

public class Trainer {

    private static double[][] invalids = new double[5][2];
    private static Map<Double, Set<Double>> accountedFor = new HashMap<>();

    public static void main(String[] args) {
//        validSlopes(new int[]{10, 8}, new int[]{4, 4});
//        ListUtils.print2D(validSlopes());
//        ListUtils.print2D(validSlopes(new int[]{3, 2}, new int[]{1, 1}));
//        isSlopeValid(new int[]{300, 275}, new double[]{90, 0}, new double[]{290, 0}, new int[]{50, 125}, 10000);
//        System.out.println(solution(new int[]{3, 2}, new int[]{1, 1}, new int[]{2, 1}, 4));
//        isSlopeValid(new int[]{300, 275}, new double[]{150, 150}, new double[]{1, 0}, new double[]{185, 100}, 60.0 / 7, 500);
        System.out.println(solution(new int[]{300, 275}, new int[]{150, 150}, new int[]{185, 100}, 5000));
    }

    public static int solution(int[] dimensions,
                               int[] your_position,
                               int[] trainer_position,
                               int distance) {
        invalids[0] = new double[]{0, 0};
        invalids[1] = new double[]{0, dimensions[1]};
        invalids[2] = new double[]{dimensions[0], 0};
        invalids[3] = new double[]{dimensions[0], dimensions[1]};
        invalids[4] = new double[]{your_position[0], your_position[1]};

        print2D(invalids);
        Set<Double> slopes = validSlopes();
        print(slopes);

        double[] pos = getDoubles(your_position);
        double[] trn = getDoubles(trainer_position);

        int valid = 0;
        if (pos[0] == trn[0]) valid++;
        if (pos[1] == trn[1]) valid++;
        for (double slope : slopes) {
            double[][] possibilities = findEdgePoints(pos, slope, dimensions);
            for (double[] possibility : possibilities) {
                if (accountedFor.containsKey(possibility[0])
                        && accountedFor.get(possibility[0]).contains(possibility[1])) return 0;
                Set<Double> set = accountedFor.getOrDefault(possibility[0], new HashSet<>());
                set.add(possibility[1]);
                accountedFor.put(possibility[0], set);
                valid += isSlopeValid(dimensions, pos, possibility, trn, slope, distance);
            }
        }
        print(accountedFor);
        System.out.println(slopes.size());
        System.out.println(accountedFor.size());
        return valid;
    }

    private static Set<Double> validSlopes() {
        int segment = 100;
        Set<Double> slopes = new TreeSet<>();
        for (int i = -segment; i < segment; i++)
            for (int k = -segment; k < segment; k++)
                if (!(i == 0 || k == 0)) slopes.add(((double) k) / (double) i);
        return slopes;
    }

    private static int isSlopeValid(int[] dimensions,
                                    double[] pos,
                                    double[] current,
                                    double[] trn,
                                    double slope,
                                    int distance) {
        List<double[]> dd = new ArrayList<>();
        dd.add(pos);
        dd.add(current);
        double length = dist(pos, current);
        while (length <= distance) {
            double[] newPt = findNextPoint(current, slope, dimensions);
            if (isOne(newPt, invalids)) return 0;
            double dis = dist(newPt, current);
            dd.add(newPt);
            if (isCollinear(current, newPt, trn)) {
                double trnDist = dist(trn, current);
                if (trnDist + length <= distance) {
                    printPath(length, dd);
                    return 1;
                } else
                    return 0;
            }
            length += dis;
            current = newPt;
            slope *= -1;
        }
        return 0;
    }

    private static double[] findNextPoint(double[] current,
                                          double slope,
                                          int[] dimensions) {
        double[][] pos = findEdgePoints(current, slope, dimensions);
        if (isSame(current, pos[0])) return pos[1];
        return pos[0];
    }

    private static double[][] findEdgePoints(double[] current, double slope, int[] dimensions) {
        double c = current[1] - (slope * current[0]);

        double xP1 = ((dimensions[1] - c)) / slope;
        double xP2 = ((-c)) / slope;
        double xP3 = 0;
        double xP4 = dimensions[0];

        double yP1 = getY(slope, c, xP1);
        double yP2 = getY(slope, c, xP2);
        double yP3 = getY(slope, c, xP3);
        double yP4 = getY(slope, c, xP4);

        double[][] pos = new double[2][2];
        int i = 0;
        if (isWithinBound(dimensions, xP1, yP1)) pos[i++] = new double[]{xP1, yP1};
        if (isWithinBound(dimensions, xP2, yP2)) pos[i++] = new double[]{xP2, yP2};
        if (isWithinBound(dimensions, xP3, yP3)) pos[i++] = new double[]{xP3, yP3};
        if (isWithinBound(dimensions, xP4, yP4)) pos[i] = new double[]{xP4, yP4};
        return pos;
    }

    private static boolean isWithinBound(int[] dimensions, double x, double y) {
        return x >= 0 && x <= dimensions[0] && y >= 0 && y <= dimensions[1] &&
                !((isSame(x, dimensions[0]) && isSame(y, dimensions[1]))
                        || (isSame(x, 0) && isSame(y, 0))
                        || (isSame(x, 0) && isSame(y, dimensions[1]))
                        || (isSame(x, dimensions[0]) && isSame(y, 0)));
    }

    private static double getY(double slope, double c, double x) {
        return (slope * x) + c;
    }

    private static double dist(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    private static boolean isCollinear(double[] f, double[] s, double[] m) {
        return f[0] * (s[1] - m[1]) + s[0] * (m[1] - f[1]) + m[0] * (f[1] - s[1]) == 0;
    }

    private static boolean isOne(double[] newPt, double[][] invalids) {
        for (double[] invalid : invalids)
            if (isSame(newPt[0], invalid[0]) && isSame(newPt[1], invalid[1])) return true;
        return false;
    }

    private static boolean isSame(double[] f, double[] s) {
        return Math.abs((f[0] - s[0]) * (f[1] - s[1])) < Math.pow(10, -6);
    }

    private static boolean isSame(double f, double s) {
        return Math.abs((f - s)) < Math.pow(10, -6);
    }

    private static double[] getDoubles(int[] pt) {
        return new double[]{pt[0], pt[1]};
    }

    private static void printPath(double length, List<double[]> dd) {
        System.out.println();
        System.out.println(length);
        for (double[] d : dd) {
            System.out.printf("(%f, %f)", d[0], d[1]);
            System.out.print(" --> ");
        }
        System.out.println();
    }
}
