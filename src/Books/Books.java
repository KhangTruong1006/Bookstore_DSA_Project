package Books;

import List.*;
import Node.Node;

import java.io.*;

public class Books {
    private SingleLinkedList<Book> books;

    public Books(String csvFile,int limit) throws IOException{
        this.books = load(csvFile,limit);
    }
    public static SingleLinkedList<Book> load(String csvFile,int limit) throws IOException {
        SingleLinkedList<Book> books = new SingleLinkedList<>();
        BufferedReader reader = null;
        String separator = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        String line;
        int i = 0;

        try  {
            reader = new BufferedReader(new FileReader(csvFile));
            String header = reader.readLine(); // Skip CSV header

            while ((line= reader.readLine()) != null && i < limit) {
                String[] row = line.split(separator);
                String title       = row.length > 0 ? row[0].trim() : "";
                String authors     = row.length > 1 ? row[1].trim() : "";
                String description = row.length > 2 ? row[2].trim() : "";
                String category    = row.length > 3 ? row[3].trim() : "";
                String publisher   = row.length > 4 ? row[4].trim() : "";
                String price       = row.length > 5 ? row[5].trim() : "";
                String pubMonth    = row.length > 6 ? row[6].trim() : "";
                String pubYear     = row.length > 7 ? row[7].trim() : "";

                Book book = new Book(i, title, authors, description,
                        category, publisher, price,
                        pubMonth, pubYear);

                books.addLast(book);
                i++;
            }
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
        return books;
    }

    public Book searchABookById(int id){
        Node<Book> current = books.getFirst();
        while (current != null){
            if (current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}
