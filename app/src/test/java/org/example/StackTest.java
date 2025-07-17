package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    Stack<Dish> stack;
    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testStackOperations() {
        Dish oneDish = new Dish("A dish with one fish pattern on it");
        Dish twoDish = new Dish("A dish with two fish patterns on it");
        Dish redDish = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        assert stack.size() == 0;

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        assert stack.size() == 4;
        assert stack.peek().description.equals("A dish with a blue fish pattern on it");

        assert stack.pop().description.equals("A dish with a blue fish pattern on it");
        assert stack.pop().description.equals("A dish with a red fish pattern on it");

        assert stack.size() == 2;

        stack.clear();
        assert stack.size() == 0;
    }

    @Test
    void testPeekOnEmptyStack() {
        assert stack.peek() == null; // or handle the empty case as per your design
    }

    @Test
    void testPopOnEmptyStack() {
        assert stack.pop() == null; // or handle the empty case as per your design
    }

    @Test
    void testPushOnFullStack() {
        for (int i = 0; i < 10; i++) {
            stack.push(new Dish("Dish " + i));
        }
        assert stack.size() == 10;

        // Attempt to push one more dish
        Dish overflowDish = new Dish("Overflow Dish");
        stack.push(overflowDish); // Should print a message that the stack is full
        assert stack.size() == 10; // Size should remain unchanged
        assert stack.peek().description.equals("Dish 9"); // Last pushed dish should still be the top
    }

    @Test
    void testIsEmptyAndIsFull() {
        assert stack.isEmpty() == true;
        assert stack.isFull() == false;

        Dish dish = new Dish("Test Dish");
        stack.push(dish);
        assert stack.isEmpty() == false;
        assert stack.isFull() == false;

        for (int i = 0; i < 9; i++) {
            stack.push(new Dish("Dish " + i));
        }
        assert stack.isFull() == true;
    }

    @Test
    void testSize() {
        assert stack.size() == 0;

        Dish dish = new Dish("Test Dish");
        stack.push(dish);
        assert stack.size() == 1;

        stack.pop();
        assert stack.size() == 0;
    }

    @Test
    void testClear() {
        Dish dish = new Dish("Test Dish");
        stack.push(dish);
        assert stack.size() == 1;

        stack.clear();
        assert stack.size() == 0;
        assert stack.peek() == null; // or handle the empty case as per your design
    }

    @Test
    void testStackInteger() {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        assert intStack.size() == 2;
        assert intStack.peek() == 2;

        assert intStack.pop() == 2;
        assert intStack.size() == 1;
        assert intStack.peek() == 1;

        intStack.clear();
        assert intStack.isEmpty();
    }

    @Test
    void testStackString() {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        assert stringStack.size() == 2;
        assert stringStack.peek().equals("World");

        assert stringStack.pop().equals("World");
        assert stringStack.size() == 1;
        assert stringStack.peek().equals("Hello");

        stringStack.clear();
        assert stringStack.isEmpty();
    }
}
