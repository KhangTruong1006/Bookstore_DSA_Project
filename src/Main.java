import java.io.*;
import Books.*;
import List.*;
import Order.*;
import Search.*;
import Sort.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        try {
            Books books = new Books("BooksDatasetClean.csv", 1000);
            Orders orders = new Orders();

            Book book1 = books.GetBookById(1);
            Book book2 = books.GetBookById(2);
            Book book3 = books.GetBookById(10);
            Book book4 = books.GetBookById(8);
            Book book5 = books.GetBookById(200);
            Book book6 = books.GetBookById(201);
            Book book7 = books.GetBookById(431);
            Book book8 = books.GetBookById(381);

            int orderId1 = 1;
            String customer1 = "John Doe";
            String address1 = "A";
            SingleLinkedList<Book> ordered_books_1 = new SingleLinkedList<>();
            ordered_books_1.addLast(book1); //1
            ordered_books_1.addLast(book3); // 10
            ordered_books_1.addLast(book4); // 8
            ordered_books_1.addLast(book2); //2
            Order order1 = new Order(orderId1,customer1,address1,ordered_books_1);
//            order1.printBookTitlesAndId();
//            System.out.println(order1.getDetails());
//            InsertionSort.sortOrderBooks(order1,InsertionSort.SortBy.ID);
//            InsertionSort.sortOrderBooks(order1,InsertionSort.SortBy.AUTHOR);
//            InsertionSort.sortOrderBooks(order1,InsertionSort.SortBy.TITLE);
//            order1.printBookTitlesAndId();


            int orderId2 = 2;
            String customer2 = "Jane Doe";
            String address2 = "B";
            SingleLinkedList<Book> ordered_books_2 = new SingleLinkedList<>();
            ordered_books_2.addLast(book4);
            ordered_books_2.addLast(book5);
            ordered_books_2.addLast(book6);
            ordered_books_2.addLast(book5);
            Order order2 = new Order(orderId2,customer2,address2,ordered_books_2);
//            InsertionSort.sortOrderBooks(order2,InsertionSort.SortBy.TITLE);
            MergeSort.sortOrderBooks(order2, MergeSort.SortBy.AUTHOR);

            int orderId3 = 3;
            String customer3 = "Alex";
            String address3 = "C";
            SingleLinkedList<Book> ordered_books_3 = new SingleLinkedList<>();
            ordered_books_3.addLast(book6);
            ordered_books_3.addLast(book7);
            ordered_books_3.addLast(book1);
            Order order3 = new Order(orderId3,customer3,address3,ordered_books_3);

            int orderId4 = 4;
            String customer4 = customer1;
            String address4 = "D";
            SingleLinkedList<Book> ordered_books_4 = new SingleLinkedList<>();
            ordered_books_4.addLast(book6);
            ordered_books_4.addLast(book7);
            ordered_books_4.addLast(book8);
            ordered_books_4.addLast(book2);
            Order order4 = new Order(orderId4,customer4,address4,ordered_books_4);

            orders.addOrder(order1);
            orders.addOrder(order2);
            orders.addOrder(order3);
            orders.addOrder(order4);

            orders.printOrders();
//             Search.searchOrderByName(orders,"John");
//             Search.searchOrderById(orders,5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}