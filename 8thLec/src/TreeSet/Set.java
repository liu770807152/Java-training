package TreeSet;


public interface Set<T> {
    /**
     * Add a value to the set if it does not already exist.
     * @param element The value to be added.
     */
    void add(T element);

    /**
     * Remove the specified value from the set.
     * @param element The value to be removed
     */
    void remove(T element);

    /**
     * Determine whether the value is in the set
     * @param element The value in question
     * @return True if the value is in the set.
     */
    boolean contains(T element);

    /**
     * @return the current size of the set.
     */
    int size();

    /**
     * @return A string representation of the list.
     */
    @Override
    String toString();
}
