package com.games.UVa.P12250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  enum Hello {
    HELLO("ENGLISH"),
    HOLA("SPANISH"),
    HALLO("GERMAN"),
    BONJOUR("FRENCH"),
    CIAO("ITALIAN"),
    ZDRAVSTVUJTE("RUSSIAN");

    private String lang;

    Hello(String pLang) {
      lang = pLang;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    int i = 1;
    while (!(line = br.readLine()).equals("#")) {
      String result = "UNKNOWN";
      try {
        Hello hello = Hello.valueOf(line);
        result = hello.lang;
      } catch (IllegalArgumentException ignored) {

      }
      System.out.printf("Case %d: %s\n", i++, result);
    }
  }
}
