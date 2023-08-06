
public class LinkedListDeque<T> {

    private Node sentinel;
    private int size;

    private class Node {
        private Node prev;
        private T data;
        private Node next;

        public Node(Node p, T d, Node n) {
            data = d;
            prev = p;
            next = n;
        }

    }

    // create an empty linked list
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T data) {
        Node first = sentinel.next;
        sentinel.next = first.prev = new Node(sentinel, data, first);
        size += 1;
        return;
    }

    public void addLast(T data) {
        Node last = sentinel.prev;
        sentinel.prev = last.next = new Node(last, data, sentinel);
        size += 1;
        return;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node n = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node n = sentinel.next;

        // organize remain nodes
        Node second = sentinel.next.next;
        sentinel.next = second;
        second.prev = sentinel;

        size -= 1;
        return n.data;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        Node n = sentinel.prev;

        // organize remain nodes
        Node lastSecond = sentinel.prev.prev;
        sentinel.prev = lastSecond;
        lastSecond.next = sentinel;

        size -= 1;
        return n.data;
    }

    public T get(int index) {
        if (index >= size || index < -size) {
            return null;
        }
        Node n = sentinel.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.data;
    }

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index >= 0 && index < size) {
            return (getRecursiveHelper(index, sentinel.next)).data;
        }
        return null;
    }

    // I think this helper function is a must for recursive method
    private Node getRecursiveHelper(int index, Node n) {
        if (index == 0) {
            return n;
        } else {
            return getRecursiveHelper(index - 1, n.next);
        }
    }

}
