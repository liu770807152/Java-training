package Map;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    private final int INITIAL_SIZE = 20;
    private LinkedList<KVPair>[] array = new LinkedList[INITIAL_SIZE];
    private int elements = 0;

    class KVPair {
        private K key;
        private V value;

        KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private int hash(K key) {
        return Math.abs (key.hashCode () % INITIAL_SIZE);
    }

    @Override
    public void put(K key, V value) {
        int slot = hash (key);
        boolean isDuplicate = false;
        if (array[slot] == null) {
            array[slot] = new LinkedList<> ();
        }
        for (KVPair temp : array[slot]) {
            if (temp.key == key) {
                isDuplicate = true;
                temp.value = value;
                break;
            }
        }
        if (!isDuplicate) {
            array[slot].add (new KVPair (key, value));
            elements++;
        }
    }

    @Override
    public void remove(K key) {
        int slot = hash (key);
        if (array[slot] == null)
            return;
        for (KVPair temp : array[slot]) {
            if (temp.key == key) {
                array[slot].remove (temp);
                elements--;
            }
        }
    }

    @Override
    public V get(K key) {
        int slot = hash (key);
        if (array[slot] == null)
            return null;
        for (KVPair temp : array[slot]) {
            if (temp.key == key)
                return temp.value;
        }
        return null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder ();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                for (KVPair temp : array[i]) {
                    result.append (temp.toString () + ", ");
                }
            }
        }
        return result.delete (result.length () - 2, result.length ()).toString ();
    }
}
