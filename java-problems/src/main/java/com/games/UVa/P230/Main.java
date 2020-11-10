package com.games.UVa.P230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Book> stock = new ArrayList<>();
    String line = "";
    while (!(line = br.readLine()).equals("END"))
      stock.add(new Book(line));
    sort(stock);
    List<Book> borrowedBooks = new ArrayList<>();
    List<Book> returnedBooks = new ArrayList<>();
    while (!(line = br.readLine()).equals("END")) {
      String[] stepSpec = line.split("\"");
      String step = stepSpec[0].trim();
      if (step.equals("BORROW")) {
        String book = stepSpec[1];
        moveBook(stock, borrowedBooks, book);
        moveBook(returnedBooks, borrowedBooks, book);
      } else if (step.equals("RETURN")) {
        String book = stepSpec[1];
        moveBook(borrowedBooks, returnedBooks, book);
      } else if (step.equals("SHELVE")) {
        List<Book> newStock = new ArrayList<>();
        newStock.addAll(stock);
        newStock.addAll(returnedBooks);
        sort(returnedBooks);
        sort(newStock);
        int newStockIndex = 0, returnedBooksIndex = 0;
        Book lastBook = null;
        while (newStockIndex < newStock.size()) {
          if (returnedBooksIndex == returnedBooks.size()) {
            System.out.println("END");
            break;
          }
          Book returnedBook = returnedBooks.get(returnedBooksIndex);
          Book stockBook = newStock.get(newStockIndex);
          if (stockBook.title.equals(returnedBook.title)) {
            if (lastBook == null) {
              System.out.printf("Put \"%s\" first\n", returnedBook.title);
            } else {
              System.out.printf("Put \"%s\" after \"%s\"\n", returnedBook.title, lastBook.title);
            }
            returnedBooksIndex++;
          } else {
            newStockIndex++;
          }
          lastBook = stockBook;
        }
        stock.clear();
        stock.addAll(newStock);
      }
    }
  }

  private static void moveBook(List<Book> stock, List<Book> stackToMove, String book) {
    if (has(stock, book)) {
      Book book1 = get(stock, book);
      stackToMove.add(book1);
      stock.remove(book1);
    }
  }

  private static boolean has(List<Book> stock, String newBook) {
    for (Book book : stock)
      if (book.title.equals(newBook))
        return true;
    return false;
  }

  private static Book get(List<Book> stock, String newBook) {
    for (Book book : stock)
      if (book.title.equals(newBook))
        return book;
    return null;
  }

  private static void sort(List<Book> stock) {
    stock.sort(Comparator.comparing((Book b) -> b.author).thenComparing(b -> b.title));
  }

  static class Book {
    String title;
    String author;

    Book(String label) {
      String[] split = label.split("\" by ");
      author = split[1];
      String[] split1 = split[0].split("\"");
      title = split1[1];
    }

    @Override
    public String toString() {
      return "Book{" +
          "title='" + title + '\'' +
          ", author='" + author + '\'' +
          '}';
    }
  }
}
