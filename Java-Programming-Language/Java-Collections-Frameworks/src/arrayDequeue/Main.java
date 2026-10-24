package arrayDequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        // Create an object of arrayDequeue.
        // By using ArrayDequeue we can able to perform stack operations as wel.
        Deque<Integer>deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // This will add elements as FIFO rule that is queue rule. First In First Out.
        for(int i = 1; i <= 10; i++) {
            // always use addLast for the queue/dequeue
            deque.addLast(i);
        }
        // This will print - [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(deque);

        // To access the deque elements always use the peekFirst.
        // Important note once we pollFirst the element is removed, and after we do all the dequeue is empty
        System.out.println("Dequeue elements access.");
        while (!deque.isEmpty()) {
            System.out.print(deque.peekFirst()+" ");
            // Why we use pollFirst here means once I get the first element I need to move to next element.
            // so I remove the first element and make my second element as first and so on.
            deque.pollFirst();
        }
        System.out.println();
        System.out.println(deque);



        // This will add elements as LIFO rule that is queue rule. Last In First Out.
        for(int i = 1; i <= 10; i++) {
            stack.addFirst(i*2);
        }
        // This will print - [2, 4, 6, 8, 10,12, 14, 16, 18, 20]
        System.out.println(stack);

        // To access the stack elements always use the peekLast
        // Important note once we pollLast the element is removed, and after we do all the stack is empty
        System.out.println("Stack elements access.");
        while (!stack.isEmpty()) {
            System.out.print(stack.peekLast()+" ");
            // Why we use pollLast here means once I get the first element I need to move to next element.
            // so I remove the first element and make my second element as first and so on.
            stack.pollLast();
        }
        System.out.println();
        System.out.println(stack);
    }
}
