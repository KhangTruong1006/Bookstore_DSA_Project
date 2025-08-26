package Order;

import Books.Book;
import List.SingleLinkedList;

public interface AbstractOrder {
    int getId();
    String getCustomerName();
    String getAddress();
    String getStatus();
    int getBook_quantity();
    float getTotal();
    SingleLinkedList<Book> getBook_list();
    String getDetails();
}
