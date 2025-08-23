package Search;

import List.*;
import Node.*;

public class LinearSearch {
    public static <E> E  searchLinkedList(DoubleLinkedList<E> linkedList, E target){
        Node<E> current = linkedList.getFirst();

        while (current != null){
            if(current.getData() == target){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}
