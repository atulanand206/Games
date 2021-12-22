package com.games.gaoc;

import com.games.utils.I;
import com.games.utils.O;
import com.games.utils.S;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Sub5 {

    private Map<String, List<String>> map;

    Sub5() {
        map = new HashMap<>();
    }

    void addEdge(String v, String w) {
        addElement(v, w);
        addElement(w, v);
    }

    private void addElement(String v, String w) {
        List<String> row = map.getOrDefault(v, new ArrayList<>());
        row.add(w);
        map.put(v, row);
    }

    int countPathsUtil(String u, String d, int pathCount) {

        // If current vertex is same as
        // destination, then increment count
        if (u.equals(d)) {
            pathCount++;
        }

        else {
            for (String n : map.get(u)) {
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    // Returns count of
    // paths from 's' to 'd'
    int countPaths(String s, String d) {

        // Call the recursive method
        // to count all paths
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, pathCount);
        return pathCount;
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
        Sub5 g = new Sub5();
        O.attach();
        BufferedReader reader = I.reader(true);
        while (reader.ready()) {
            String[] x = reader.readLine().split("-");
            g.addEdge(x[0], x[1]);
        }
        O.debug(S.string(g.map));
        String s = "start", d = "end";
//        System.out.println(g.countPaths(s, d));
    }

    @Override
    public String toString() {
        return map.toString();
    }
}