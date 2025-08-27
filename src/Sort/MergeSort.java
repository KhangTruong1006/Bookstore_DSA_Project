package Sort;

import Books.*;
import List.SingleLinkedList;
import Node.Node;
import Order.*;

public class MergeSort {
    public enum SortBy{
        ID, TITLE, AUTHOR
    }

    public static void sortOrderBooks(Order order, SortBy sortBy){
        if (order == null || order.getBook_list() == null) return;
        sort(order.getBook_list(), sortBy);
    }

    private static void sort(SingleLinkedList<Book> list,SortBy sortBy){
        if (list == null || list.isEmpty()){
            return;
        }
        Node<Book> newHead = mergeSort(list.getFirst(),sortBy);
        list.setHead(newHead);
    }

    private static Node<Book> mergeSort(Node<Book> head, SortBy sortBy){
        if(head == null || head.getNext() == null){
            return head;
        }
        Node<Book> middle = getMiddle(head);
        Node<Book> nextOfMiddle = middle.getNext();
        middle.setNext(null);

        Node<Book> left = mergeSort(head, sortBy);
        Node<Book> right = mergeSort(nextOfMiddle,sortBy);

        return merge(left,right,sortBy);
    }

    private static Node<Book> merge(Node<Book> left, Node<Book> right, SortBy sortBy){
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node<Book> result;
        if(compare(left.getData(),right.getData(),sortBy) <= 0){
            result = left;
            result.setNext(merge(left.getNext(),right,sortBy));
        }
        else{
            result = right;
            result.setNext(merge(left,right.getNext(),sortBy));
        }
        return result;
    }

    private static int compare(Book b1, Book b2, SortBy sortBy){
        switch (sortBy){
            case TITLE:
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            case AUTHOR:
                return b1.getAuthors().compareToIgnoreCase(b2.getAuthors());
            case ID:
            default:
                return Integer.compare(b1.getId(),b2.getId());
        }
    }

    private static Node<Book> getMiddle(Node<Book> head){
        if(head == null){
            return head;
        }
        Node<Book> fast = head, slow = head;
        while (fast.getNext()!= null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
