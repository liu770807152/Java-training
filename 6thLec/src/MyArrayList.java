public class MyArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private static final float GROWTH_FACTOR = 1.5f;

    private T[] values = (T[]) new Object[INITIAL_SIZE];  // Java 'feature', can't allocate array of generic type T
    int elements;

    @Override
    public void add(T value) {
        if (elements == values.length) { // need to grow
            T[] tmp = (T[]) new Object[(int) (values.length * GROWTH_FACTOR)];
            for (int i = 0; i < values.length; i++) {
                tmp[i] = values[i];
            }
            values = tmp;
        }
        // values[elements++] = value;
        values[elements] = value;
        elements++;
    }

    @Override
    public T remove(int index) {
        T rtn = values[index];
        elements--;
        for (int i = index; i < elements; i++) {
            values[i] = values[i+1];
        }
        return rtn;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public void reverse() {
        for (int i = 0; i < elements/2; i++) {
            T tmp = values[i];
            values[i] = values[(elements - 1)-i];
            values[(elements - 1)-i] = tmp;
        }
    }

    @Override
    public String toString() {
        String rtn = "";
        for (int i  = 0; i < elements; i++) {
            // rtn += ((i > 0) ? " " : "")+values[i];
            if (i > 0) {
                rtn += " ";
            }
            rtn += values[i];
        }
        return rtn;
    }
}
