package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Create a Queue

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=5; i++){
            // To add the elements in the queue.
            queue.offer(i*2);
        }

        System.out.println(queue);

        // get the first element
        System.out.println(queue.peek());

        // remove the first element
        System.out.println(queue.poll());
        // Prints by eliminate the first element.
        System.out.println(queue);

        // Return true or false
        System.out.println(queue.isEmpty());

    }
}
