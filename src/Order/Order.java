package Order;
import Books.*;
import Node.*;
import List.*;

public class Order {
    private int id;
    private String customer_name;
    private String address;
    private String status; // Processing-Shipped-Received
    private int book_quantity;
    private float total;
    private SingleLinkedList<Book> book_list;

    public Order(int id, String customer_name, String address, SingleLinkedList<Book> book_list){
        this.id = id;
        this.customer_name = customer_name;
        this.address = address;
        this.status = "Processing";
        this.book_quantity = book_list.size();
        this.book_list = book_list;
        this.total = calculateTotal();
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void printBookTitlesAndId(){
        Node<Book> current = book_list.getFirst();
        while (current != null){
            Book data = current.getData();
            String title = data.getTitle();
            String authors = data.getAuthors();
            long id = data.getId();
            System.out.println(id +" - "+title +" "+authors);
            current = current.getNext();
        }
    }

    public String getDetails() {
        return String.format("Id: %d\nName: %s\nAddress: %s\nStatus: %s\nQuantity: %d\nPrice: $%.2f\nBooks:",
                id, customer_name, address, status, book_quantity, total);
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

    private float calculateTotal(){
        Node<Book> current = book_list.getFirst();
        float total = 0;
        while (current != null){
            total += current.getData().getPrice();
            current = current.getNext();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nAddress: %s\nStatus: %s\nQuantity: %d\nPrice: $%.2f\nBooks:",
                id, customer_name, address, status, book_quantity, total);
    }
}
