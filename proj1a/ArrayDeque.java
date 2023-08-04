public class ArrayDeque<T> {

    private T[] m_data;
    private int m_size;

    public ArrayDeque() {
        m_data = (T []) new Object[8];
        m_size = 0;
    }

    public void add(T data) {
        if (m_size == m_data.length) {
            resize(m_data.length * 2);
        }
        m_data[m_size] = data;
        m_size += 1;
    }

    private void resize(int capacity) {
        T[] temp = (T []) new Object[capacity];
        System.arraycopy(temp, 0, m_data, 0, m_size);
        m_data = temp;
    }

    private T getLast() {
        return m_data[m_size - 1];
    }

    public T remove() {
        m_size -= 1;
        T last = getLast();
        m_data[m_size] = null;
        if (m_size < (m_data.length / 4)) {
            resize(m_data.length / 2);
        }
        return last;
    }

    public T get(int index) {
        return m_data[index];
    }

    public int size() {
        return m_size;
    }

}
