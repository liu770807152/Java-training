package Set;

public class BSTSet<T> implements Set<T>{
    private int elements = 0;
    private BSTree tree;

    class BSTree {
        private T value;
        private BSTree left, right;
        BSTree() {
            value = null;
            left = right = null;
        }
        BSTree(T element) {
            value = element;
            left = right = null;
        }

        public BSTree add(T element) {
            if (element == null) {
                return null;
            } else if (this.value == null) {
                value = element;
                return this;
            }
            else if (this.value.equals (element)) {
                return null;
            } else if (element.hashCode () > this.value.hashCode ()) {
                if (right == null) {
                    right = new BSTree ();
                }
                return right.add (element);
            }
            else {
                if (left == null) {
                    left = new BSTree ();
                }
                return left.add (element);
            }
        }

        public void add(BSTree other) {
            if (other != null && other.value != null) {
                this.add (other.value);
                this.add (other.left);
                this.add (other.right);
            }
        }

        public BSTree find(T value) {
            if (value == null || this.value == null) {
                return null;
            } else if (value.hashCode () < this.value.hashCode ()) {
                return left == null ? null : left.find (value);
            } else if (value.hashCode () > this.value.hashCode ()) {
                return right == null ? null : right.find (value);
            } else {
                return this;
            }
        }

        @Override
        public String toString() {
            String result = "";
            if (left != null && left.value != null) {
                result += left.value + ", ";
            }
            result += this.value;
            if (right != null && right.value != null) {
                result += ", " + right.value;
            }
            return result;
        }
    }

    @Override
    public void add(T element) {
        if (element != null) {
            if (tree == null) {
                tree = new BSTree (element);
                elements++;
            } else {
                if (tree.add (element) != null) {
                    elements++;
                }
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element != null) {
            BSTree root = tree.find (element);
            BSTree lchild, rchild;
            if (root != null) {
                lchild = root.left;
                rchild = root.right;
                root.value = null;
                root.left = root.right = null;
                tree.add (lchild);
                tree.add (rchild);
                elements--;
            }
        }
    }

    @Override
    public boolean contains(T element) {
        return tree.find (element) != null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String result = "";
        if (tree == null) {
            result = null;
        } else {
            result += tree;
        }
        return result;
    }
}
