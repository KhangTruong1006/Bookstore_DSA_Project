package Order;
import Queue.*;
import Books.*;
import List.*;

public class Order {
    private int id;
    private String customer_name;
    private String address;
    private int book_quantity;
    private SingleLinkedList<Book> book_list;

    public Order(int id, String customer_name, String address, SingleLinkedList<Book> book_list){
        this.id = id;
        this.customer_name = customer_name;
        this.address = address;
        this.book_quantity = book_list.size();
        this.book_list = book_list;
    }

    public int getId(){
        return id;
    }

    public String getCustomer_name(){
        return customer_name;
    }

    public String getAddress(){
        return address;
    }

    public int getBook_quantity(){
        return book_quantity;
    }

    public SingleLinkedList<Book> getBook_list() {
        return book_list;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nAddress: %s\nQuantity: %d\nBooks: %s\n",
                id, customer_name, address, book_quantity, book_list);
    }
}
