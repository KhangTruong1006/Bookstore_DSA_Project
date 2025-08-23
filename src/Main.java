import java.io.*;
import Books.*;
import List.*;
import Search.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        try {

            SingleLinkedList<Book> books = Books.load("BooksDatasetClean.csv", 100);
            int i = 1;

//            books.printAllData();
              String target = "10";
              SingleLinkedList<Book> result = SearchBook.search(books,target);
              System.out.println("Books found: " + result.size());
              result.printAllData();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}