package Set;

public class BSTSet<T> implements Set<T>{
    BSTree tree;
    int elements;
    boolean containsNull = false;  // denote whether this set contains the element null.

    class BSTree {
        /* Note that BSTree does not support the null element.   Since TreeSet needs
           to handle the null element it must do so itself, as a special case */
        T element;
        BSTree left, right;

        // 为了避免技术细节上的麻烦，不实现构造器，默认所有属性为null

        // 为了避免泛型的比较，老师的代码修改为比较hashcode
        BSTree add(T element) {
            // 普通的添加操作
            if (this.element == null) {
                this.element = element;
                return this;
            } else if (element.equals(this.element)) {
                return null;
            } else if (element.hashCode() <= this.element.hashCode()) {
                if (this.left == null) {
                    left = new BSTree();
                }
                return left.add(element);
            } else {
                if (this.right == null) {
                    right = new BSTree();
                }
                return right.add(element);
            }
        }

        // overload
        void add(BSTree subtree) {
            if (subtree != null && subtree.element != null) {
                this.add(subtree.element);
                this.add(subtree.left);
                this.add(subtree.right);
            }
        }

        BSTree find(T element) { // FIXME
            // element不应该为null
            if (element != null && this.element != null) {
                if (this.element.equals(element)) {
                    return this;
                } else if (element.hashCode() > this.element.hashCode()) {
                    if (this.right == null) {
                        return null;
                    }
                    return right.find(element);
                } else {
                    if (this.left == null) {
                        return null;
                    }
                    return left.find(element);
                }
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder temp = new StringBuilder();
            // 前序遍历
            if (this.element != null) {

                if (this.left != null && this.left.element != null) {
                    temp.append(this.left.toString() +", ");
                }
                temp.append(this.element.toString() +", ") ;
                if (this.right != null && this.right.element != null) {
                    temp.append(this.right.toString() +", ") ;
                }
            }
            return temp.delete(temp.length()-2, temp.length()).toString();
        }
    }

    /**
     * Add a value to the set if it does not already exist.
     *
     * @param element The value to be added.
     */
    @Override
    public void add(T element) {
        // for null, don't use the tree, just use the special boolean
        if (element == null) {
            if (!this.containsNull) {
                this.containsNull = true;
                elements++;
            }
        } else {
            if (this.tree == null) {
                this.tree = new BSTree();
            }
            if (this.tree.add(element) != null) {
                elements++;
            }
        }
    }

    @Override
    public void remove(T element) {
        // don't use the tree for the null element
        if (element == null && this.containsNull) {
            this.containsNull = false;
            elements--;
        }
        BSTree found = this.tree.find(element);
        if (found != null) {
            BSTree left = found.left;
            BSTree right = found.right;
            found.element = null;
            found.left = found.right = null;
            elements--;
            this.tree.add(left);
            this.tree.add(right);
        }
    }

    @Override
    public boolean contains(T element) {
        // 注意element为null的特殊情况
        if (element == null) {
            return this.containsNull;
        } else if (this.tree == null) {
            return false;
        } else {
            return this.tree.find(element) != null;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString() {
        String t = tree == null ? "" : tree.toString();
        // 当存有null时，序列化方法要特殊处理
        if (containsNull) {
            return "null" + (t.equals("") ? "" : ", " + t);
        } else {
            return t;
        }
    }
}
