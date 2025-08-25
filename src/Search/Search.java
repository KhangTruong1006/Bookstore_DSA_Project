package Search;
import List.*;
import Books.*;
import Node.*;
import Order.*;
import Queue.Queue;

// Searching book will use linear search
public class Search {
    public static SingleLinkedList<Book> searchBooks(SingleLinkedList<Book> books,String target){
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

    public static Book searchABookById(SingleLinkedList<Book> books,int id){
        Node<Book> current = books.getFirst();
        while (current != null){
            if (current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public static void searchOrderByName(Orders orders, String customer){
        Node<Order> current = orders.getFirst();
//        SingleLinkedList<Order> result = new SingleLinkedList<>();
        while(current != null){
            Order order = current.getData();
            if(order.getCustomer_name().contains(customer)){
                System.out.println(order);
                order.printBookTitleAndAuthors();
            }
            current = current.getNext();
        }
        System.out.println("No order found");
        return ;
    }
}
