/*
 * Authors: Student (Group 1)
 * Date: April 2026
 * Purpose: Represents a double linked list data structure.
 * Public methods:
 * - insert(int): inserts a value at the end of the list
 * - insertAt(int, int): inserts a value at a specific position
 * - delete(int): deletes the first occurrence of a value
 * - deleteAt(int): deletes the element at a specific position
 * - traverse(): returns all elements as a string
 * - getSize(): returns the number of elements
 * - isEmpty(): checks if the list is empty
 * - getFirst(): returns the first element
 * - getLast(): returns the last element
 */

import java.util.OptionalInt;

public class DLList {

    private Node head;
    private Node tail;
    private int size;

    public DLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        this.size++;
    }

    public void insertAt(int data, int position) {
        if (position < 0 || position > this.size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            Node newNode = new Node(data);
            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.setNext(this.head);
                this.head.setPrev(newNode);
                this.head = newNode;
            }
            this.size++;
            return;
        }
        if (position == this.size) {
            this.insert(data);
            return;
        }
        Node current = this.head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(data);
        newNode.setNext(current.getNext());
        newNode.setPrev(current);
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        this.size++;
    }

    public boolean delete(int data) {
        if (this.isEmpty()) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.getData() == data) {
                if (current == this.head) {
                    this.head = current.getNext();
                    if (this.head != null) {
                        this.head.setPrev(null);
                    }
                } else if (current == this.tail) {
                    this.tail = current.getPrev();
                    this.tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                this.size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteAt(int position) {
        if (position < 0 || position >= this.size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        Node current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        if (current == this.head) {
            this.head = current.getNext();
            if (this.head != null) {
                this.head.setPrev(null);
            }
        } else if (current == this.tail) {
            this.tail = current.getPrev();
            this.tail.setNext(null);
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        if (this.isEmpty()) {
            this.tail = null;
        }
        this.size--;
        return true;
    }

    public String traverse() {
        StringBuilder result = new StringBuilder();
        Node current = this.head;
        while (current != null) {
            result.append(current.getData()).append(" <-> ");
            current = current.getNext();
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 5);
        }
        return result.toString();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public OptionalInt getFirst() {
        if (this.isEmpty()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.head.getData());
    }

    public OptionalInt getLast() {
        if (this.isEmpty()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.tail.getData());
    }

    protected Node getHead() {
        return this.head;
    }

    protected Node getTail() {
        return this.tail;
    }

    protected void setHead(Node head) {
        this.head = head;
    }

    protected void setTail(Node tail) {
        this.tail = tail;
    }

    protected void setSize(int size) {
        this.size = size;
    }
}
