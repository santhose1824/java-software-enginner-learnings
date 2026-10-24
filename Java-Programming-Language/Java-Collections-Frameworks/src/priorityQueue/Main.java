package priorityQueue;

import priorityQueue.comparableAndComparator.StudentMarks;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create an object of priority queue.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());

        List<Integer> list = new ArrayList<>(priorityQueue);
        System.out.println(list);

        for(int i = 1; i <= 10; i++) {
            priorityQueue.add(i*3);
        }
        //[3, 6, 9, 12, 15, 18, 21, 24, 27, 30]
        System.out.println(priorityQueue);

        // Same Queue methods are used
        while(!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.peek()+" ");
            priorityQueue.poll();
        }
        System.out.println();
        System.out.println(priorityQueue);

        for(int i = 1; i <= 10; i++) {
            priorityQueue.add(i*3);
        }

        // I want the bottom elements from the priority queue. why I say bottom is that the values in queue is FIFO.
        // So the first element is goes to last and return first.
        List<Integer> list1 = new ArrayList<>();
        int index = 0;
        while(!priorityQueue.isEmpty()) {
            if(index == 3){
                break;
            }
            list1.add(priorityQueue.poll());
            index++;
        }
        System.out.println(list);
        System.out.println(priorityQueue);

        // Now let's try to get the top 3 students based on the maths marks.

        List<StudentMarks> studentMarksList = new ArrayList<>();

        studentMarksList.add(new StudentMarks(90,85));
        studentMarksList.add(new StudentMarks(80,55));
        studentMarksList.add(new StudentMarks(92,95));
        studentMarksList.add(new StudentMarks(100,100));
        studentMarksList.add(new StudentMarks(70,65));

        // Here we use
        PriorityQueue<StudentMarks> studentMarks = new PriorityQueue<>();
        List<StudentMarks> topThreeStudents = new ArrayList<>();
        System.out.println(studentMarks);
        index = 0;
        while(!studentMarks.isEmpty()) {
            if(index == 3){
                break;
            }
            topThreeStudents.add(studentMarks.poll());
            index++;
        }

        // This will throw the below error
        /*
            Exception in thread "main" java.lang.ClassCastException: class priorityQueue.
            StudentMarks cannot be cast to class java.lang.
            Comparable (priorityQueue.comparableAndComparator.StudentMarks is in unnamed module of loader 'app';
            java.lang.Comparable is in module java.base of loader 'bootstrap')
        */
        System.out.println(topThreeStudents);
    }
}
