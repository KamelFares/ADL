/*
 * Authors: Student (Group 1)
 * Date: April 2026
 * Purpose: Test class for elementary data structures (DLList, Dequeue, Stack).
 * Public methods:
 * - main(String[]): entry point that runs all tests
 * - testDLList(): tests all DLList methods
 * - testDequeue(): tests all Dequeue methods
 * - testStack(): tests all Stack methods
 * - testTransformations(): tests dequeue to stack and stack to dequeue conversions
 */

public class Test {

    private static final int[] TEST_DATA = {5, 12, 3, 27, 8, 15, 42, 1, 88, 33, 19};

    public static void main(String[] args) {
        System.out.println("===== Test Data =====");
        printTestData();
        System.out.println("\n===== Testing DLList =====");
        testDLList();
        System.out.println("\n===== Testing Dequeue =====");
        testDequeue();
        System.out.println("\n===== Testing Stack =====");
        testStack();
        System.out.println("\n===== Testing Transformations =====");
        testTransformations();
        System.out.println("\n===== All Tests Completed =====");
    }

    private static void printTestData() {
        System.out.print("Test data: ");
        for (int value : TEST_DATA) {
            System.out.print(value + " ");
        }
        System.out.println("\nNumber of test items: " + TEST_DATA.length);
    }

    private static void testDLList() {
        DLList list = new DLList();
        System.out.println("1. Testing insert() and traverse()");
        for (int value : TEST_DATA) {
            list.insert(value);
        }
        System.out.println("   List: " + list.traverse());
        System.out.println("   Size: " + list.getSize());
        System.out.println("2. Testing getFirst() and getLast()");
        System.out.println("   First element: " + list.getFirst());
        System.out.println("   Last element: " + list.getLast());
        System.out.println("3. Testing insertAt()");
        list.insertAt(99, 5);
        System.out.println("   After insertAt(99, 5): " + list.traverse());
        System.out.println("   Size: " + list.getSize());
        System.out.println("4. Testing delete()");
        boolean deleted = list.delete(27);
        System.out.println("   After delete(27): " + list.traverse());
        System.out.println("   Delete successful: " + deleted);
        System.out.println("   Size: " + list.getSize());
        System.out.println("5. Testing deleteAt()");
        list.deleteAt(0);
        System.out.println("   After deleteAt(0): " + list.traverse());
        System.out.println("   Size: " + list.getSize());
        System.out.println("6. Testing isEmpty()");
        System.out.println("   Is empty: " + list.isEmpty());
    }

    private static void testDequeue() {
        Dequeue dequeue = new Dequeue();
        System.out.println("1. Testing enqueueLast() and traverse()");
        for (int i = 0; i < 5; i++) {
            dequeue.enqueueLast(TEST_DATA[i]);
        }
        System.out.println("   Dequeue: " + dequeue.traverse());
        System.out.println("   Size: " + dequeue.getSize());
        System.out.println("2. Testing enqueueFirst()");
        dequeue.enqueueFirst(100);
        System.out.println("   After enqueueFirst(100): " + dequeue.traverse());
        System.out.println("   Size: " + dequeue.getSize());
        System.out.println("3. Testing peekFirst() and peekLast()");
        System.out.println("   First element: " + dequeue.peekFirst());
        System.out.println("   Last element: " + dequeue.peekLast());
        System.out.println("4. Testing dequeueFirst()");
        int first = dequeue.dequeueFirst();
        System.out.println("   Dequeued first: " + first);
        System.out.println("   After dequeueFirst(): " + dequeue.traverse());
        System.out.println("   Size: " + dequeue.getSize());
        System.out.println("5. Testing dequeueLast()");
        int last = dequeue.dequeueLast();
        System.out.println("   Dequeued last: " + last);
        System.out.println("   After dequeueLast(): " + dequeue.traverse());
        System.out.println("   Size: " + dequeue.getSize());
        System.out.println("6. Testing isEmpty()");
        System.out.println("   Is empty: " + dequeue.isEmpty());
    }

    private static void testStack() {
        Stack stack = new Stack();
        System.out.println("1. Testing push() and traverse()");
        for (int i = 0; i < 6; i++) {
            stack.push(TEST_DATA[i]);
        }
        System.out.println("   Stack: " + stack.traverse());
        System.out.println("   Size: " + stack.getSize());
        System.out.println("2. Testing peek()");
        System.out.println("   Top element: " + stack.peek());
        System.out.println("   Size after peek: " + stack.getSize());
        System.out.println("3. Testing pop()");
        int popped = stack.pop();
        System.out.println("   Popped element: " + popped);
        System.out.println("   After pop(): " + stack.traverse());
        System.out.println("   Size: " + stack.getSize());
        System.out.println("4. Testing isEmpty()");
        System.out.println("   Is empty: " + stack.isEmpty());
    }

    private static void testTransformations() {
        System.out.println("1. Testing Dequeue to Stack transformation");
        Dequeue dequeue = new Dequeue();
        for (int i = 0; i < 5; i++) {
            dequeue.enqueueLast(TEST_DATA[i]);
        }
        System.out.println("   Original Dequeue: " + dequeue.traverse());
        Stack stack = dequeue.toStack();
        System.out.println("   Transformed Stack: " + stack.traverse());
        System.out.println("   Stack size: " + stack.getSize());
        System.out.println("2. Testing Stack to Dequeue transformation");
        Stack stack2 = new Stack();
        for (int i = 5; i < 9; i++) {
            stack2.push(TEST_DATA[i]);
        }
        System.out.println("   Original Stack: " + stack2.traverse());
        Dequeue dequeue2 = stack2.toDequeue();
        System.out.println("   Transformed Dequeue: " + dequeue2.traverse());
        System.out.println("   Dequeue size: " + dequeue2.getSize());
    }
}
