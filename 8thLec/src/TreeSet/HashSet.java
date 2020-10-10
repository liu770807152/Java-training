package TreeSet;

import java.util.LinkedList;


public class HashSet<T> implements Set<T> {
    final static int DEFAULT_BKTS = 2; // just for testing; make bigger later

    LinkedList<T>[] table;
    int elements;

    private int hash(T element) { return element == null ? 0 : Math.abs(element.hashCode() % table.length);}

    public HashSet() {
        table = new LinkedList[DEFAULT_BKTS];
    }

    @Override
    public void add(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll == null) {
            table[bkt] = new LinkedList<>();
            ll = table[bkt];
        }
        if (!ll.contains(element)) {
            ll.add(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll != null && ll.contains(element)) {
            ll.remove(element);
            elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        int bkt = hash(element);
        LinkedList<T> ll = table[bkt];
        if (ll != null) {
            return ll.contains(element);
        }
        return false;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String rtn = "";
        for (int bkt = 0; bkt < table.length; bkt++) {
            LinkedList<T> ll = table[bkt];
            if (ll != null) {
                for (T e : ll) {
                    if (!rtn.equals("")) { rtn += ", "; }
                    rtn += e == null ? "null" : e.toString();
                }
            }
        }
        return rtn;
    }
}
