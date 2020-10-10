package TreeSet;


public class TreeSet<T> implements Set<T> {
    BSTree tree;
    int elements;
    boolean containsNull = false;  // denote whether this set contains the element null.

    class BSTree {
        /* Note that BSTree does not support the null element.   Since TreeSet needs
           to handle the null element it must do so itself, as a special case */
        T element;
        BSTree left, right;

        BSTree add(T element) {
            if (this.element == null) {
                this.element = element;
                return this;
            } else if (this.element.equals(element)) {
                return null; // already in tree (signify this with null)
            } else if (element.hashCode() > this.element.hashCode()) {
                if (right == null) {
                    right = new BSTree();
                }
                return right.add(element);
            } else {
                if (left == null) {
                    left = new BSTree();
                }
                return left.add(element);
            }
        }

        void add(BSTree subtree) {
            if (subtree != null && subtree.element != null) {
                add(subtree.element);
                add(subtree.right);
                add(subtree.left);
            }
        }

        BSTree find(T element) {
            if (this.element != null && element != null) {
                if (this.element.equals(element)) // found
                {
                    return this;
                } else if (element.hashCode() > this.element.hashCode()) {
                    if (right == null) {
                        return null;
                    } else {
                        return right.find(element);
                    }
                } else {
                    if (left == null) {
                        return null;
                    } else {
                        return left.find(element);
                    }
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String rtn = "";
            if (this.element != null) {
                if (left != null && left.element != null) {
                    rtn += left.toString() + ", ";
                }
                rtn += this.element;
                if (right != null && right.element != null) {
                    rtn += ", " + right.toString();
                }
            }
            return rtn;
        }
    }

    @Override
    public void add(T element) {
        if (element == null) {   // for null, don't use the tree, just use the special boolean
            if (!containsNull) {
                containsNull = true;
                elements++;
            }
        } else {
            if (tree == null) {
                tree = new BSTree();
            }
            if (tree.add(element) != null) {
                elements++;
            }
        }
    }

    @Override
    public void remove(T element) {
        if (element == null) {  // don't use the tree for the null element
            if (containsNull) {
                containsNull = false;
                elements--;
            }
        } else {
            BSTree root = tree.find(element);
            if (root != null) {
                BSTree l = root.left;  // we don't want to remove this
                BSTree r = root.right; // we don't want to remove this
                root.element = null;  // this the thing we were removing
                elements--;
                root.left = null;
                root.right = null;
                tree.add(l);
                tree.add(r);
            }
        }
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            return containsNull;
        } else if (tree == null) {
            return false;
        } else {
            return tree.find(element) != null;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String t = tree == null ? "" : tree.toString();
        if (containsNull) {
            return "null" + (t.equals("") ? "" : ", " + t);
        } else {
            return t;
        }
    }
}
