package List;
import Node.*;
import java.util.Arrays;

public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);
        if(this.size != 0){
            newNode.setNext(head);
            head.setPrevious(newNode);
        }
        else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E data){
        Node<E> newNode = new Node<>(data);
        if(this.size != 0){
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public Node<E> removeFirst(){
        ensureNotEmpty();
        Node<E> oldNode = this.head;
        this.head = oldNode.getNext();
        if (this.head != null){
            this.head.setPrevious(null);
        }
        else{
            this.tail = null;
        }
        this.size --;
        return oldNode;
    }

    public Node<E> removeLast(){
        ensureNotEmpty();
        Node<E> oldNode = this.tail;
        this.tail = oldNode.getPrevious();
        if (this.tail != null){
            this.tail.setNext(null);
        }
        else{
            this.head = null;
        }
        this.size--;
        return oldNode;
    }

    public Node<E> getFirst(){
        return this.head;
    }
    public Node<E> getLast(){
        return this.tail;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void printAllData(){
        Node<E> current = head;
        while (current != null) {
            E data = current.getData();
            System.out.println(data);
            current = current.getNext();
        }
    }
    // Private functions
    private void ensureNotEmpty(){
        if(this.head == null || this.tail == null || this.size == 0) {
            throw new IllegalStateException(String.format("The list is empty"));
        }
    }
}

