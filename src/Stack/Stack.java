package Stack;

import Node.Node;

public class Stack<E> {
    private Node<E> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(E data){
        Node<E> newNode = new Node<>(data);
        if (top != null) {
            newNode.setNext(top);
        }
        top = newNode;
        size++;
    }

    public E pop(){
        ensureNotEmpty();
        Node<E> oldTop = top;
        top = oldTop.getNext();
        oldTop.setNext(null);
        size--;
        return oldTop.getData();
    }

    public E peek(){
        ensureNotEmpty();
        return top.getData();
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return this.size;
    }

    private void ensureNotEmpty(){
        if(size < 1 || top ==null){
            throw new IllegalStateException(String.format("The stack is empty"));
        }
    }
}

