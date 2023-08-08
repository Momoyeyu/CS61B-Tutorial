public interface Deque<T> {

    public int size();
    public boolean isEmpty();
    public void printDeque();
    public T get(int index);
    public void addFirst(T data);
    public void addLast(T data);
    public T removeFirst();
    public T removeLast();

}
