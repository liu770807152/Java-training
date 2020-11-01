package Set;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {
    final static int DEFAULT_BKTS = 20;

    LinkedList<T>[] table;
    int elements;

    private int hash(T element) {
        return element == null ? 0 : Math.abs(element.hashCode() % DEFAULT_BKTS);
    }

    public HashSet() {
        table = new LinkedList[DEFAULT_BKTS];
        elements = 0;
    }

    @Override
    public void add(T element) { // SOLID -> S: single responsibility
        int slot = hash(element);
        LinkedList<T> cur = table[slot];
        if (cur == null) {
            table[slot] = new LinkedList<>();
            cur = table[slot];
        }
        if (!cur.contains(element)) {
            cur.add(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int slot = hash(element);
        if (table[slot] != null && table[slot].contains(element)) {
            table[slot].remove(element);
            elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        int slot = hash(element);
        if (table[slot] != null) {
            return table[slot].contains(element);
        }
        return false;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int cur = 0; cur < table.length; cur++) {
            LinkedList curList = table[cur];
            if (curList != null) {
                for (Object t : curList){
                    if (t == null) {
                        temp.append("null, ");
                    } else {
                        temp.append(t.toString() + ", ");
                    }
                }
            }
        }
        return temp.delete(temp.length()-2, temp.length()).toString();
    }
}
