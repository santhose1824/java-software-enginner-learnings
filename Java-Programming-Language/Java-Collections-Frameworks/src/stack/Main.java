package stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Stack object creation.
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 10; i++) {
            // insert the elements in the stack.
            stack.push(i);
        }

        // This will print stack using toString() so it will print in the order we insert.
        System.out.println(stack);

        // get elements from the stack.
        // This will print in reverse order because stack is first come last out.
        // To perform any operations with the stack focus on access like this .
        while(!stack.isEmpty()) {
            // This will return the elements in the top of stack.
            System.out.print(stack.peek() + " ");

            // this will remove the top element from the stack.
            // Why I am using pop inside the get elements because once I get the top element I need to move to next element.
            // If I didn't pop and again call the peek() it will give the same top element.
            // This will finally make the stack empty.
            stack.pop();
        }
        System.out.println();
        System.out.println(stack);
    }
}
