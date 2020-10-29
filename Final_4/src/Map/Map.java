package Map;

public interface Map<K, V> {
    /**
     * Add a (key, value) pair to the map.   If the key already exists,
     * overwrite the existing value with the value provided.
     * @param key The key to be added.
     * @param value The value to be added.
     */
    public void put(K key, V value);

    /**
     * Remove the specified key from the map, along with the associated
     * value.
     * @param key The key to be removed
     */
    public void remove(K key);

    /**
     * Return the value associated with the given key, or null if
     * the key is not in the map.
     * @param key The key in question
     * @return The value associated with the key, or null if there is none.
     */
    public V get(K key);

    /**
     * @return the current size of the map.
     */
    public int size();

    /**
     * @return A string representation of the map.
     */
    public String toString();
}
