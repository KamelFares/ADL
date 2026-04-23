/*
 * Authors: Kamel (Group 1)
 * Date: April 2026
 * Represents a dequeue (double-ended queue) data structure.
 * Public methods:
 * - enqueueFirst(int): adds an element to the front
 * - enqueueLast(int): adds an element to the back
 * - dequeueFirst(): removes and returns the front element
 * - dequeueLast(): removes and returns the back element
 * - peekFirst(): returns the front element without removing
 * - peekLast(): returns the back element without removing
 * - traverse(): returns all elements as a string
 * - getSize(): returns the number of elements
 * - isEmpty(): checks if the dequeue is empty
 * - toStack(): transforms the dequeue into a stack
 */
package Dequeue;

public class Dequeue {

    private DLList list;

    public Dequeue() {
        this.list = new DLList();
    }

    public void enqueueFirst(int data) {
        this.list.insertAt(data, 0);
    }

    public void enqueueLast(int data) {
        this.list.insert(data);
    }

    public int dequeueFirst() {
        if (this.list.isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        int data = this.list.getFirst();
        this.list.deleteAt(0);
        return data;
    }

    public int dequeueLast() {
        if (this.list.isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        int data = this.list.getLast();
        this.list.deleteAt(this.list.getSize() - 1);
        return data;
    }

    public int peekFirst() {
        if (this.list.isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        return this.list.getFirst();
    }

    public int peekLast() {
        if (this.list.isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
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

    public Stack toStack() {
        Stack stack = new Stack();
        for (int i = 0; i < this.list.getSize(); i++) {
            Node current = this.list.getHead();
            for (int j = 0; j < i; j++) {
                current = current.getNext();
            }
            stack.push(current.getData());
        }
        return stack;
    }
}
