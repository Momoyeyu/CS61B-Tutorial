public class ArrayDeque<T> {

    private T[] m_data;
    private int m_size;
    private int m_step;

    public ArrayDeque() {
        m_data = (T []) new Object[8];
        m_size = 0;
        m_step = 0;
    }

    private int indexing(int index) {
        if (index >= m_data.length){
            return index - m_data.length;
        }
        else if (index < 0) {
            return index + m_data.length;
        }
        else {
            return index;
        }
    }

    public void addFirst(T data) {
        if (m_size == m_data.length) {
            resize(m_data.length * 2);
        }
        m_step += 1;
        final int first_index = indexing(m_data.length - m_step);
        m_data[first_index] = data;
        m_size += 1;
    }

    public void addLast(T data) {
        if (m_size == m_data.length) {
            resize(m_data.length * 2);
        }
        final int last_index = indexing(m_size - m_step);
        m_data[last_index] = data;
        m_size += 1;
    }

    public T removeFirst() {
        T first = getFirst();
        final int first_index = indexing(m_data.length - m_step);
        m_data[first_index] = null;
        m_size -= 1;
        if (m_size < (m_data.length / 4)) {
            resize(m_data.length / 2);
        }
        return first;
    }

    public T removeLast() {
        T last = getLast();
        final int last_index = indexing(m_size - 1 - m_step);
        m_data[last_index] = null;
        m_size -= 1;
        m_data[m_size - m_step] = null;
        if (m_size < (m_data.length / 4)) {
            resize(m_data.length / 2);
        }
        return last;
    }

    public boolean isEmpty() {
        return m_size == 0;
    }

    private void resize(int capacity) {
        T[] temp = (T []) new Object[capacity];
        System.arraycopy(temp, 0, m_data, 0, m_size - m_step);
        System.arraycopy(temp, temp.length - m_step, m_data, m_data.length - m_step, m_step);
        m_data = temp;
    }

    public T getFirst() {
        final int first_index = indexing(m_data.length - m_step);
        return m_data[first_index];
    }

    private T getLast() {
        final int last_index = indexing(m_size - 1 - m_step);
        return m_data[last_index];
    }
    public T get(int index) {
        index = indexing(index - m_step);
        return m_data[index];
    }

    public int size() {
        return m_size;
    }

}
