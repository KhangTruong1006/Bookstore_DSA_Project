package Node;

public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> previous;

    public Node(E inputData){
        this.data = inputData;
    }

    public Node<E> getNext(){
        return this.next;
    }

    public Node<E> getPrevious(){
        return this.previous;
    }

    public void setData(E data){
        this.data = data;
    }

    public E getData(){
        return this.data;
    }
    public void setNext(Node<E> p){
        this.next = p;
    }

    public void setPrevious(Node<E> p){
        this.previous = p;
    }
}

