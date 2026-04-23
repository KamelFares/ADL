/*
 * Authors: Student (Group 1)
 * Date: April 2026
 * Purpose: Represents a stack (Last-In-First-Out) data structure.
  Public methods:
 * - push(int): adds an element to the top of the stack
 * - pop(): removes and returns the top element
 * - peek(): returns the top element without removing
 * - traverse(): returns all elements as a string
 * - getSize(): returns the number of elements
 * - isEmpty(): checks if the stack is empty
 * - toDequeue(): transforms the stack into a dequeue
 */

import java.util.OptionalInt;

public class Stack {

    private DLList list;

    public Stack() {
        this.list = new DLList();
    }

    public void push(int data) {
        this.list.insert(data);
    }

    public OptionalInt pop() {
        if (this.list.isEmpty()) {
            return OptionalInt.empty();
        }
        int data = this.list.getLast().getAsInt();
        this.list.deleteAt(this.list.getSize() - 1);
        return OptionalInt.of(data);
    }

    public OptionalInt peek() {
        if (this.list.isEmpty()) {
            return OptionalInt.empty();
        }
        return this.list.getLast();
    }

    public String traverse() {
        return this.list.traverse();
    }

    public int getSize() {
        return this.list.getSize();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Dequeue toDequeue() {
        Dequeue dequeue = new Dequeue();
        Stack temp = new Stack();

    while (!this.isEmpty()) {
        int value = this.pop().getAsInt();
        temp.push(value);
    }

    while (!temp.isEmpty()) {
        int value = temp.pop().getAsInt();
        dequeue.enqueueLast(value);
        this.push(value);
    }

    return dequeue;
}}
