
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
        final int length = array.length;
        while (index >= length) {
            index -= length;
        }
        while (index < 0) {
            index += length;
        }
        return index;
    }

    public void addFirst(T data) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        step += 1; // first need step
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
        step -= 1; // first need step
        if (size <= (array.length / 4) && array.length > 8) {
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
        if (size <= (array.length / 4) && array.length > 8) {
            resize(array.length / 2);
        }
        return last;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        final int firstIndex = stepping(array.length - step);
        final int lastIndex = stepping(size - 1 - step);
        if (firstIndex <= lastIndex) {
            // copy from first to last
            System.arraycopy(array, firstIndex, temp, 0, size);
            step = 0;
        } else {
            // copy from array[firstIndex] to array[array.length - 1]
            System.arraycopy(array, firstIndex, temp, 0, step);
            // copy from array[0] to array[lastIndex]
            System.arraycopy(array, 0, temp, step, size - step);
            step = 0;
        }

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
