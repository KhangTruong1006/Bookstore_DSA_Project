package Order;

import Node.*;
import Queue.*;

public class Orders {
    private Queue<Order> orders;
    private int quantity;

    public Orders(){
        this.orders = new Queue<Order>();
        this.quantity = 0;
    }

    public void addOrder(Order order){
        orders.insert(order);
        quantity++;
    }

    public int getQuantity(){
        return quantity;
    }

    public Node<Order> getFirst(){
        return orders.peekFront();
    }

    public void printOrders(){
        Node<Order> current = orders.peekFront();
        while (current != null){
            System.out.println(current.getData().getDetails());
            current.getData().printBookTitleAndAuthors();
            System.out.println();
            current = current.getNext();
        }
    }
}
