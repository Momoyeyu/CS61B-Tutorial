
/** second part of project1A.
 * deque implemented by array
 * @author Momoyeyu
 */
public class ArrayDeque<T> {

    private T[] array;
    private int size;
    private int step;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        step = 0;
    }

    private int stepping(int index) {
        if (index >= array.length) {
            return index - array.length;
        } else if (index < 0) {
            return index + array.length;
        } else {
            return index;
        }
    }

    public void addFirst(T data) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        step += 1;
        final int firstIndex = stepping(array.length - step);
        array[firstIndex] = data;
        size += 1;
    }

    public void addLast(T data) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        final int lastIndex = stepping(size - step);
        array[lastIndex] = data;
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = getFirst();
        final int firstIndex = stepping(array.length - step);
        array[firstIndex] = null;
        size -= 1;
        step -= 1;
        if (size <= (array.length / 4) && !isEmpty()) {
            resize(array.length / 2);
        }
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = getLast();
        final int lastIndex = stepping(size - 1 - step);
        array[lastIndex] = null;
        size -= 1;
        if (size <= (array.length / 4) && !isEmpty()) {
            resize(array.length / 2);
        }
        return last;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, temp, 0, size - step);
        System.arraycopy(array, array.length - step, temp, temp.length - step, step);
        array = temp;
    }

    private T getFirst() {
        if (isEmpty()) {
            return null;
        }
        final int firstIndex = stepping(array.length - step);
        return array[firstIndex];
    }

    private T getLast() {
        if (isEmpty()) {
            return null;
        }
        final int lastIndex = stepping(size - 1 - step);
        return array[lastIndex];
    }
    public T get(int index) {
        if (index >= size || index < -size) {
            return null;
        }
        index = stepping(index - step);
        return array[index];
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        final int first = array.length - step;
        System.out.print("[ ");
        for (int i = first; i < first + size; i++) {
            System.out.print(array[stepping(i)] + " ");
        }
        System.out.print("]\n");
    }

}
