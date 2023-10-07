package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> array1 = new ArrayList<>(List.of(1, 3, 7, 5, 3, 5, 9, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(array1);
        System.out.println(linkedList);

        LinkedList<Integer> linkedList2 = new LinkedList(List.of(0,2,1));

        //the same methods as ArrayList and:

        //add element on the first position
        linkedList2.addFirst(9);
        System.out.println(linkedList2);

        //add element on the last position
        linkedList2.addLast(0);
        System.out.println(linkedList2);

        //clear whole list
        linkedList.clear();
        System.out.println(linkedList);

        //return shallow copy of linked list
        LinkedList<Integer> linkedList3 = new LinkedList<>();
        linkedList3 = (LinkedList) linkedList2.clone();
        System.out.println(linkedList3);

        //return iterator over elements in this deque in reverse order
        Iterator x = linkedList2.descendingIterator();
        while (x.hasNext()) {
            System.out.println(x.next());
        }

        //retrieving (but not removing) first element (head) of the list
        System.out.println(linkedList2.element());

        //get first element
        System.out.println(linkedList2.getFirst());

        //get last element
        System.out.println(linkedList2.getLast());
        System.out.println();

        //return list Iterator starting at given position
        Iterator y = linkedList2.listIterator(2);
        while (y.hasNext()) {
            System.out.println(y.next());
        }

        //adding element to the tail or head of the list. queue method. not throwing exception
        //if queue is size restricted could return false
        linkedList2.offer(4);
        System.out.println(linkedList2);

        //retrieve and remove head of the list
        System.out.println(linkedList2.poll());
        System.out.println(linkedList2);
        System.out.println(linkedList2.pollFirst());
        System.out.println(linkedList2);
        System.out.println(linkedList2.pollLast());
        System.out.println(linkedList2);

        //pops element from the stack represented by the list
        System.out.println(linkedList2.pop());
        System.out.println(linkedList2);

        //push element onto the stack represented by the list
        linkedList2.push(2);

        //remove first/last occurrence
        System.out.println(linkedList3);
        System.out.println(linkedList3.removeFirstOccurrence(0));
        System.out.println(linkedList3);
        System.out.println(linkedList3.removeLastOccurrence(0));
        System.out.println(linkedList3);

        //return an array
        Object[] list = linkedList2.toArray();
        System.out.println(list);
        for(Object o : list) {
            System.out.println(o);
        }





    }
}