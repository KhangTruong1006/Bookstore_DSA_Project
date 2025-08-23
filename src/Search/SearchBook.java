package Search;
import List.*;
import Books.*;
import Node.*;

// Searching book will use linear search
public class SearchBook {
    public static SingleLinkedList<Book> search(SingleLinkedList<Book> books,String target){
        Node<Book> current = books.getFirst();
        SingleLinkedList<Book> result = new SingleLinkedList<>();
        while(current != null){
            Book book = current.getData();
            if(book.getDetails().contains(target)){
                result.addFirst(book);
            }
            current = current.getNext();
        }
        return result;
    }
}
