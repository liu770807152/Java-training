package Map;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    final static int DEFAULT_BKTS = 20; // just for testing; make bigger later

    LinkedList<KVPair>[] table;
    int elements;

    private int hash(K element) { return element == null ? 0 : Math.abs(element.hashCode() % table.length);}
    public HashMap() {
        table = new LinkedList[DEFAULT_BKTS];
    }

    class KVPair {
        K key;
        V value;

        KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "("+key+", "+value+")";
        }
    }

    KVPair find(LinkedList<KVPair> ll, K key) {
        for (KVPair kv : ll) {
            if ((kv.key == null && key == null) || kv.key.equals(key))
                return kv;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll == null) {
            table[bkt] = new LinkedList<>();
            ll = table[bkt];
        }
        KVPair kv = find(ll, key);
        if (kv == null) {
            kv = new KVPair(key, value);
            ll.add(kv);
            elements++;
        } else {
            kv.value = value;
        }
    }

    @Override
    public void remove(K key) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll != null) {
            KVPair kv = find(ll, key);
            if (kv != null) {
                ll.remove(kv);
                elements--;
            }
        }
    }

    @Override
    public V get(K key) {
        int bkt = hash(key);
        LinkedList<KVPair> ll = table[bkt];
        if (ll != null) {
            KVPair kv = find(ll, key);
            return kv == null ? null : kv.value;
        }
        return null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String rtn = "";
        for (int bkt = 0; bkt < table.length; bkt++) {
            LinkedList<KVPair> ll = table[bkt];
            if (ll != null) {
                for (KVPair kv : ll) {
                    if (!rtn.equals("")) { rtn += ", "; }
                    rtn += kv;
                }
            }
        }
        return rtn;
    }
}
