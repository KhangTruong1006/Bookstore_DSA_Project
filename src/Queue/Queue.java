package Queue;

import Node.Node;

public class Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }

    public void insert(E data){
        Node<E> newNode = new Node<>(data);
        if(isEmpty()){
            front = rear = newNode;
        }
        else{
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public E pull(){
        ensureNotEmpty();
        Node<E> oldNode = front;
        front = front.getNext();

        if(front == null){
            rear = null;
        }
        size --;
        oldNode.setNext(null);
        return oldNode.getData();
    }

    public Node<E> peekFront(){
        ensureNotEmpty();
        return this.front;
    }

    public E peekRear(){
        ensureNotEmpty();
        return this.rear.getData();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureNotEmpty(){
        if(isEmpty()){
            throw new IllegalStateException(String.format("The queue is empty"));
        }
    }
}

