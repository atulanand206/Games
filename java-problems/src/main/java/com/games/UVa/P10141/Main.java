package com.games.UVa.P10141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    int cases = 1;
    while (!(line = br.readLine()).equals("0 0")) {
      if (cases != 1)
        System.out.println();
      String[] specs = line.split(" ");
      int requirementsCount = at(specs, 0);
      int proposalsCount = at(specs, 1);
      ignoreLines(br, requirementsCount);
      String name = "";
      int bestCompliant = 0;
      double bestPrice = Double.MAX_VALUE;
      for (int i = 0; i < proposalsCount; i++) {
        String proposalName = br.readLine();
        String[] proposalSpec = br.readLine().trim().split(" ");
        double proposalValue = Double.parseDouble(proposalSpec[0]);
        int compliance = at(proposalSpec, 1);
        if (isBetterProposal(bestCompliant, bestPrice, proposalValue, compliance)) {
          name = proposalName;
          bestCompliant = compliance;
          bestPrice = proposalValue;
        }
        ignoreLines(br, compliance);
      }
      System.out.printf("RFP #%d\n%s\n", cases, name);
      cases++;
    }
  }

  private static boolean isBetterProposal(int bestCompliant, double bestPrice, double proposalValue, int compliance) {
    return (compliance > bestCompliant) || (compliance == bestCompliant && proposalValue < bestPrice);
  }

  private static void ignoreLines(BufferedReader br, int count) throws IOException {
    for (int i = 0; i < count; i++) {
      br.readLine();
    }
  }

  private static int at(String[] array, int index) {
    return Integer.parseInt(array[index]);
  }
}
