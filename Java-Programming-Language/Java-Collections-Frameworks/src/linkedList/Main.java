package linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // LinkedList Creation;
        // LinkedList is also implements the List interface so methods in LinkedList and ArrayList are quite same.
        List<String> linkList = new LinkedList<>();

        // add method in linkedList.
        linkList.add("Santhose");
        linkList.add("Hayagreevan");
        linkList.add("Someone");
        linkList.add("Some people");
        linkList.add("Random people");

        // print the linkedList.
        System.out.println(linkList);


        // size of linkedList
        System.out.println(linkList.size());

        // traverse through linkedList. 0 based index.

        for (String s : linkList) {
            System.out.println(s);
        }

        // set() - in arraylist if we set the value at the index position which is not existing or more than the size of list it shows IndexOutOfBounds error.
        // but in the linkedList it is added as the last node of the list, because LinkedList are actually works insert and delete based on node.
        linkList.set(3,"Hari Krishnan");
        System.out.println(linkList);

        ListIterator<String> iterator = linkList.listIterator();


        // This will return ans like this
        /*
            This is the list.
            [Santhose, Hayagreevan, Someone, Hari Krishnan, Random people]
            When we say next() first it prints the value at index 0 and moves the cursor to nextIndex 1.
            Now if we say nexIndex() this will show 1 because we haven't move the cursor yet.
            Again if we said next() first prints the value at index 1 and move the cursor to nextIndex 2.
            Now if we say previousIndex() it will show the index 1 which is previousIndex of 2.
            If we say previous() it will first move the cursor to the previous index and then print

            Basically what happens is
            for next() - list[index++];
            for previous() - list[--index];
        */

        System.out.println(iterator.next());
        System.out.println(iterator.nextIndex());
        System.out.println(iterator.next());
        System.out.println(iterator.nextIndex());
        System.out.println(iterator.previousIndex());
        System.out.println(iterator.previous());

    }
}
