package Set;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    private final int tableSize = 20;
    private LinkedList<T>[] hashTable;
    private int elements;

    HashSet() {
        hashTable = new LinkedList[tableSize];
        elements = 0;
    }

    private int hash(T element) {
        return Math.abs (element.hashCode () % tableSize);
    }

    @Override
    public void add(T element) {
        int slot = hash(element);
        if (hashTable[slot] == null) {
            hashTable[slot] = new LinkedList<> ();
        }
        if (!hashTable[slot].contains (element)) {
            hashTable[slot].add (element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int slot = hash(element);
        if (hashTable[slot] == null) {
            return;
        }
        if (hashTable[slot].remove (element)) {
            elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        int slot = hash (element);
        if (hashTable[slot] == null) {
            return false;
        }
        return hashTable[slot].contains(element);
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder ();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                for (T temp : hashTable[i]) {
                    result.append (temp.toString () + ", ");
                }
            }
        }
        return result.delete(result.length () - 2, result.length ()).toString ();
    }
}
