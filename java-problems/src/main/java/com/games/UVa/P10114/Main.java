package com.games.UVa.P10114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    while (!(line = br.readLine()).contains("-")) {
      String[] vals = line.split(" ");
      int durationInMonths = Integer.parseInt(vals[0]);
      double downPayment = Double.parseDouble(vals[1]);
      double loanAmount = Double.parseDouble(vals[2]);
      double loanInstallment = loanAmount/durationInMonths;
      int depreciationRecords = Integer.parseInt(vals[3]);
      double carsWorth = downPayment + loanAmount;
      int[] months = new int[depreciationRecords];
      double[] depRate = new double[depreciationRecords];
      for (int i = 0; i < depreciationRecords; i++) {
        String[] record = br.readLine().split(" ");
        months[i] = Integer.parseInt(record[0]);
        depRate[i] = Double.parseDouble(record[1]);
      }
      int currentDepRecordIndex = 0;
      for (int currentMonth = 0; currentMonth < durationInMonths; currentMonth++) {
        if (loanAmount > carsWorth) {
          System.out.printf("%s month", currentMonth);
          if (currentMonth>1)
            System.out.print("s");
          System.out.println();
          break;
        }
        carsWorth = carsWorth - carsWorth * depRate[currentDepRecordIndex];
        loanAmount = loanAmount - loanInstallment;
        System.out.println(carsWorth);
        System.out.println(loanAmount);
        if (currentMonth == months[currentDepRecordIndex]) {
          currentDepRecordIndex++;
        }
      }
    }
  }
}
