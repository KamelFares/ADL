/*
 * Authors: Student (Group 1)
 * Date: April 2026
 * Purpose: Represents a node element for linked data structures.
 * Public methods: 
 * - getData(): returns the integer data
 * - setData(int): sets the integer data
 * - getNext(): returns the next node reference
 * - setNext(Node): sets the next node reference
 * - getPrev(): returns the previous node reference
 * - setPrev(Node): sets the previous node reference
 */
package main;

public class Node {

    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
