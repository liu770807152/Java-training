package List;


public class ArrayList<T> implements List<T>{
    private final int INITIAL_SIZE = 2;
    private final double GROWTH_RATE = 1.5;
    private T[] array = (T[]) new Object[INITIAL_SIZE];
    private int size = 0;


    @Override
    public void add(T value) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[(int) (size * GROWTH_RATE)];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size++] = value;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T[] temp = (T[]) new Object[--size];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        for (int i = index; i < size; i++) {
            temp[i] = array[i+1];
        }
        array = temp;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reverse() {
        if (size == 0) {
            return;
        }
        T temp;
        for (int i = 0; i < size / 2; i++) {
            int newIndex = size - i - 1;
            temp = array[i];
            array[i] = array[newIndex];
            array[newIndex] = temp;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            for (T temp : array) {
                result.append(temp + " ");
            }
            return result.deleteCharAt (result.length() - 1).toString();
        }
    }
}
