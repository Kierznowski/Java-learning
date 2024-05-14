package org.example;


import java.util.List;


//ArrayList can be slower than standard array but gives us flexibility
//in manipulation of the List
public class ArrayList {
    public static void main(String[] args) {

        List<Integer> list1 = new java.util.ArrayList<>();

        //adding element in specific index
        list1.add(0,1);
        list1.add(1,2);
        System.out.println(list1);

        //adding other list to the list
        List<Integer> list2 = new java.util.ArrayList<>();
        //adding without specified indexes
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list1.addAll(list2);

        System.out.println(list2);
        System.out.println(list1);

        //removing element from the list with specific index
        //if we are not using List of Integers we can remove specific element value
        list1.remove(1);
        System.out.println(list1);

        //get element from the list by index
        System.out.println(list1.get(3));

        //change value of the element in the list
        list1.set(0, 7);
        System.out.println(list1);


        //adding element in already used index moved other elements forward
        list1.add(0,3);
        System.out.println(list1);

        //get index of the element
        System.out.println(list1.indexOf(3));

        //get last index of the element
        System.out.println(list1.lastIndexOf(3));

        //checking if element is present in a List
        System.out.println(list1.contains(7));
        System.out.println(list1.contains(4));

        //Iterating trough the List
        for(Integer element : list1) {
            System.out.println(element+1);
        }
        System.out.println();

        //size of the list
        System.out.println(list1.size());

        //clear whole list
        list2.clear();
        System.out.println(list2);

        //checking if list is empty
        System.out.println(list1.isEmpty());
        System.out.println(list2.isEmpty());

        //checking equality
        list2.add(3);
        System.out.println(list2.equals(List.of(3)));

        //checking if contains whole list
        List<Integer> list3 = new java.util.ArrayList<>();
        list3.add(2);
        list3.add(1);
        list3.add(4);
        list3.add(3);
        list2.add(2);

        System.out.println(list3.containsAll(list2));

        //sorting
        //list1.sort(Comparator comparator);


    }
}