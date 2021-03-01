package Map;

public class BSTMap<K, V> implements Map<K, V> {
    BSTree tree;
    int elements;

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

    class BSTree {
        KVPair kv;
        BSTree left, right;

        BSTree add(KVPair kv) {
            if (this.kv == null) {
                this.kv = kv;
                return this;
            } else if (this.kv.equals(kv)) {
                return null; // already in tree (signify this with null)
            } else if (kv.key == null || (this.kv.key != null && kv.key.hashCode() > this.kv.key.hashCode())) {  // FIXME deal with null key!!
                if (right == null) {
                    right = new BSTree();
                }
                return right.add(kv);
            } else {
                if (left == null) {
                    left = new BSTree();
                }
                return left.add(kv);
            }
        }

        void add(BSTree subtree) {
            if (subtree != null && subtree.kv != null) {
                add(subtree.kv);
                add(subtree.right);
                add(subtree.left);
            }
        }

        BSTree find(K key) { // FIXME deal with null key
            if (this.kv != null) {
                if (key == null) {
                    if (this.kv.key == null) {
                        return this;
                    } else {
                        return right == null ? null : right.find(key); // null -> 1
                    }
                } else {
                    if (this.kv.key != null && this.kv.key.equals(key)) // found
                    {
                        return this;
                    } else if (kv.key == null || key.hashCode() <= this.kv.key.hashCode()) {
                        if (left == null) {
                            return null;
                        } else {
                            return left.find(key);
                        }
                    } else {
                        if (right == null) {
                            return null;
                        } else {
                            return right.find(key);
                        }
                    }
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String rtn = "";
            if (this.kv != null) {
                if (left != null && left.kv != null) {
                    rtn += left.toString() + ", ";
                }
                rtn += this.kv;
                if (right != null && right.kv != null) {
                    rtn += ", " + right.toString();
                }
            }
            return rtn;
        }
    }

    @Override
    public void put(K key, V value) {
        if (tree == null) {
            tree = new BSTree();
        }

        BSTree t = tree.find(key);
        if (t != null) {
            t.kv.value = value; // found, so just update the value
        } else {
            KVPair kv = new KVPair(key, value);
            tree.add(kv);
            elements++;
        }
    }

    @Override
    public void remove(K key) {
        BSTree root = tree.find(key);
        if (root != null) {
            BSTree l = root.left;  // we don't want to remove this
            BSTree r = root.right; // we don't want to remove this
            root.kv = null;  // this the thing we were removing
            elements--;
            root.left = null;
            root.right = null;
            tree.add(l);
            tree.add(r);
        }
    }

    @Override
    public V get(K key) {
        if (tree == null) {
            return null;
        } else {
            BSTree t = tree.find(key);
            if (t == null) {
                return null;
            } else {
                return t.kv.value;
            }
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        return tree == null ? "" : tree.toString();
    }
}
