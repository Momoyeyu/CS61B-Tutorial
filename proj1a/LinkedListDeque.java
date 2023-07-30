import sun.awt.image.ImageWatched;

public class LinkedListDeque<T> {

    private Node m_sentinel;
    private int m_size;

    private class Node {
        public Node prev;
        public T data;
        public Node next;

        public Node(Node p, T d, Node n) {
            data = d;
            prev = p;
            next = n;
        }

    }

    // create an empty linked list
    public LinkedListDeque() {
        m_sentinel = new Node(null, null, null);
        m_sentinel.prev = m_sentinel.next = m_sentinel;
        m_size = 0;
    }

    public void addFirst(T data) {
        Node first = m_sentinel.next;
        m_sentinel.next = first.prev = new Node(m_sentinel, data, first);
        m_size += 1;
        return;
    }

    public void addLast(T data) {
        Node last = m_sentinel.prev;
        m_sentinel.prev = last.next = new Node(last, data, m_sentinel);
        m_size += 1;
        return;
    }

    public boolean isEmpty() { return (m_size == 0); }

    public int size() { return m_size; }

    public void printDeque() {
        Node n = m_sentinel.next;
        for (int i = 0; i < m_size; i++) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty())
            return null;
        Node n = m_sentinel.next;

        // organize remain nodes
        Node second = m_sentinel.next.next;
        m_sentinel.next = second;
        second.prev = m_sentinel;

        m_size -= 1;
        return n.data;
    }

    public T removeLast() {
        if (this.isEmpty())
            return null;
        Node n = m_sentinel.prev;

        // organize remain nodes
        Node last_second = m_sentinel.prev.prev;
        m_sentinel.prev = last_second;
        last_second.next = m_sentinel;

        m_size -= 1;
        return n.data;
    }

    public T get(int index) {
        if (index >= 0 && index < m_size){
            Node n = m_sentinel.next;
            for(int i = 0;i < index; i++) {
                n = n.next;
            }
            return n.data;
        }
        // when no such data exist, return null
        return null;
    }

    public T getRecursive(int index) {
        if (index >= 0 && index < m_size){
            return (getRecursiveHelper(index, m_sentinel.next)).data;
        }
        return null;
    }

    // I think this helper function is a must for recursive method
    private Node getRecursiveHelper(int index, Node n) {
        if (index == 0)
            return n;
        else
            return getRecursiveHelper(index - 1, n.next);
    }

}
