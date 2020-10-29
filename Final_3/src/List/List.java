package List;

public interface List<T> {
    public void add(T value);
    public void remove(int index);
    public T get(int index);
    public int size();
    public void reverse();
    @Override
    public String toString();
}

