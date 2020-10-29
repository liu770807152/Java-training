package Map;

public class BSTMap<K, V> implements Map<K, V> {
    private int elements = 0;
    private BSTree tree;

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

    class BSTree {
        private KVPair pair;
        private BSTree left, right;

        public BSTree add(KVPair pair) {
            if (pair == null || pair.key == null || pair.value == null)
                return null;
            if (this.pair == null) {
                this.pair = pair;
                return this;
            }
            else if (this.pair.equals (pair)) {
                return null;
            }
            else if (this.pair.key.equals (pair.key)) {
                this.pair.value = pair.value;
                return null;
            }
            else if (pair.key.hashCode () > this.pair.key.hashCode ()) {
                if (right == null)
                    right = new BSTree ();
                return right.add (pair);
            }
            else {
                if (left == null)
                    left = new BSTree ();
                 return left.add (pair);
            }
        }

        public void add(BSTree other) {
            if (other != null) {
                add (other.pair);
                add (other.left);
                add (other.right);
            }
        }

        BSTree find(K key) {
            if (key == null || this.pair == null)
                return null;
            else if (this.pair.key.equals (key))
                return this;
            else if (key.hashCode () > pair.key.hashCode ())
                return right == null ? null : right.find(key);
            else
                return left == null ? null : left.find(key);
        }

        @Override
        public String toString() {
            String result = "";
            if (pair != null) {
                if (left != null && left.pair != null)
                    result += left + ", ";
                result += pair;
                if (right != null && right.pair != null)
                    result += ", " + right;
            }
            return result;
        }
    }

    @Override
    public void put(K key, V value) {
        if (key != null) {
            if (tree == null)
                tree = new BSTree ();
            if (tree.add (new KVPair (key, value)) != null)
                elements++;
        }
    }

    @Override
    public void remove(K key) {
        if (tree != null) {
            BSTree root = tree.find (key);
            BSTree lchild, rchild;
            if (root != null) {
                lchild = root.left;
                rchild = root.right;
                root.pair = null;
                root.left = root.right = null;
                tree.add (lchild);
                tree.add (rchild);
                elements--;
            }
        }
    }

    @Override
    public V get(K key) {
        if (tree == null)
            return null;
        else {
            if (tree.find (key) == null)
                return null;
            else
                return tree.find (key).pair.value;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String result = "";
        if (tree == null)
            return null;
        else {
            result += tree;
            return result;
        }
    }
}
