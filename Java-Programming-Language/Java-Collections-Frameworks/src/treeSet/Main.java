package treeSet;

import priorityQueue.comparableAndComparator.StudentMarks;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<StudentMarks> studentMarksList = new ArrayList<>();

        studentMarksList.add(new StudentMarks(90,85));
        studentMarksList.add(new StudentMarks(80,55));
        studentMarksList.add(new StudentMarks(92,95));
        studentMarksList.add(new StudentMarks(100,100));
        studentMarksList.add(new StudentMarks(70,65));

        // Create a TreeSet object.
        Set<StudentMarks>  set = new TreeSet<>(studentMarksList);

        for (StudentMarks studentMarks : studentMarksList) {
            System.out.print(studentMarks+" ");
        }
        System.out.println();

        NavigableSet<Integer>  set2 = new TreeSet<>();

        for (int i = 1; i<=10; i++) {
            set2.add(i);
        }

        System.out.println(set2);

        // TreeSet Methods with Navigable interface

        // floor - gives less than or equal to the e.
        // For this ans is 10 because 11 is not there it prints nearby small value 10
        System.out.println(set2.floor(11));

        // ceiling - gives greater than  or equal to the e.
        // For this ans is 1 because 0 is not there it prints nearby greater value 1
        System.out.println(set2.ceiling(0));

        // higher - gives exactly the value greater than e.
        // For this the ans is 9 because the next higher value after the 8 is 9.
        // If the value is not present return null
        System.out.println(set2.higher(8));

        // lower - gives exactly the value lower than e.
        // For this the ans is 3 because the next higher value after the 4 is 3.
        // If the value is not present return null
        System.out.println(set2.lower(0));

        // pollFirst - returns the first element from the tree set.
        System.out.println(set2.pollFirst());

        //pollLast - returns the last element from the tree set.
        System.out.println(set2.pollLast());
    }
}
