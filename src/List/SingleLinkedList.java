package List;
import Node.Node;
import java.util.Arrays;

public class SingleLinkedList<E> {
    private Node<E> head;
    private int size;

    public SingleLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);
        if(this.head != null){
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    public void addLast(E data){
        Node<E> newNode = new Node<>(data);
        if(this.size == 0 || this.head == null){
            this.head = newNode;
        }
        else{
            Node<E> current = this.head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Node<E> removeFirst(){
        ensureNotEmpty();
        Node<E> oldNode = this.head;
        this.head = oldNode.getNext();
        oldNode.setNext(null);
        this.size --;
        return oldNode;
    }

    public Node<E> removeLast(){
        ensureNotEmpty();
        Node<E> current = this.head;
        if(current.getNext() == null){
            this.head = null;
            size--;
            return current;
        }
        while (current.getNext().getNext() != null){
            current = current.getNext();
        }
        Node<E> oldNode = current.getNext();
        current.setNext(null);
        size--;
        return  oldNode;
    }

    public Node<E> getFirst(){
        return this.head;
    }

    public Node<E> getLast(){
        ensureNotEmpty();
        Node<E> current = this.head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current;
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
            if (data instanceof String[]) {
                System.out.println(Arrays.toString((String[]) data));
            } else {
                System.out.println(data);
            }
            current = current.getNext();
        }
    }
    public void setHead(Node<E> newHead) {
        this.head = newHead;

        // Optional: update size
        this.size = 0;
        Node<E> current = newHead;
        while (current != null) {
            this.size++;
            current = current.getNext();
        }
    }


    // Private functions
    private void ensureNotEmpty(){
        if(this.head == null) {
            throw new IllegalStateException(String.format("The list is empty"));
        }
    }
}


