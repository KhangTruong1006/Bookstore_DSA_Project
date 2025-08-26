package Sort;

import List.*;
import Books.*;
import Node.Node;
import Order.*;

public class InsertionSort {

    public enum SortBy {
        ID, TITLE, AUTHOR
    }

    public static void sortOrderBooks(Order order, SortBy sortBy) {
        if (order == null || order.getBook_list() == null) return;
        sort(order.getBook_list(), sortBy);
    }

    private static void sort(SingleLinkedList<Book> list, SortBy sortBy) {
        if (list == null || list.size() <= 1) return;

        Node<Book> sorted = null;
        Node<Book> current = list.getFirst();

        while (current != null) {
            Node<Book> next = current.getNext();
            sorted = insertSorted(sorted, current, sortBy);
            current = next;
        }

        list.setHead(sorted);
    }

    private static Node<Book> insertSorted(Node<Book> head, Node<Book> newNode, SortBy sortBy) {
        if (head == null || compare(newNode.getData(), head.getData(), sortBy) < 0) {
            newNode.setNext(head);
            return newNode;
        }

        Node<Book> current = head;
        while (current.getNext() != null &&
                compare(newNode.getData(), current.getNext().getData(), sortBy) >= 0) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        return head;
    }

    private static int compare(Book b1, Book b2, SortBy sortBy) {
        switch (sortBy) {
            case TITLE:
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            case AUTHOR:
                return b1.getAuthors().compareToIgnoreCase(b2.getAuthors());
            case ID:
            default:
                return Integer.compare(b1.getId(), b2.getId());
        }
    }
}
