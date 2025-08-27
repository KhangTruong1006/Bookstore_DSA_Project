package Search;
import List.*;
import Books.*;
import Node.*;
import Order.*;
import Queue.Queue;

// Searching book will use linear search
public class Search {
    public static void searchBooks(SingleLinkedList<Book> books,String target){
        Node<Book> current = books.getFirst();
        while(current != null){
            Book book = current.getData();
            if(book.getDetails().contains(target)){
                System.out.println(book.getDetails());
            }
            current = current.getNext();
        }
        System.out.println("No book found");
    }

    public static void searchABookById(SingleLinkedList<Book> books,int id){
        Node<Book> current = books.getFirst();
        while (current != null){
            if (current.getData().getId() == id){
                System.out.println(current.getData().getDetails());
            }
            current = current.getNext();
        }
        System.out.println("No book found");
    }

    public static void searchOrderByName(Orders orders, String customer){
        Node<Order> current = orders.getFirst();
        while(current != null){
            Order order = current.getData();
            if(order.getCustomerName().contains(customer)){
                System.out.println(order);
                order.printBookTitleAndAuthors();
                System.out.println();
            }
            current = current.getNext();
        }
        System.out.println("No order found");
    }

    public static void searchOrderById(Orders orders, int id){
        Node<Order> current = orders.getFirst();
        while(current != null){
            Order order = current.getData();
            if(order.getId()== id){
                System.out.println(order);
                order.printBookTitleAndAuthors();
                return;
            }
            current = current.getNext();
        }
    }
}
