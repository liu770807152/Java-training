package List;

public class LinkedList<T> implements List<T>{
    private int size = 0;
    private Node first, last = null;

    class Node {
        private T value;
        private Node next;
        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (Node temp = this; temp != null; temp = temp.next) {
                result.append(temp.value + " ");
            }
            return result.deleteCharAt(result.length() - 1).toString();
        }
    }

    @Override
    public void add(T value) {
        if (value == null) {
            return;
        }
        if (first == null) {
            first = last = new Node(value, null);
            size++;
        } else {
            last.next = new Node(value, null);
            last = last.next;
            size++;
        }
    }

    private Node find(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public void remove(int index) {
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        // 当删除的节点是第一个时，只需要更新first
        if (index == 0) {
            first = first.next;
            if (first == null) {
                last = null;
            }
            size--;
        }
        else {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            Node temp = find(index - 1);
            // 当删除的节点是最后一个时，需要反向更新last
            if (temp.next == last) {
                temp.next = temp.next.next;
                last = temp;
                size--;
            } else {
                temp.next = temp.next.next;
                size--;
            }
        }
    }

    @Override
    public T get(int index) {
        return find(index).value;
    }

    @Override
    public int size() {
        return size;
    }

    private Node recursiveReversal(Node oldFirst) {
        if (oldFirst.next == null) {
            return oldFirst;
        }
        Node temp = oldFirst.next;
        Node newFirst = recursiveReversal(temp);
        temp.next = oldFirst;
        return newFirst;
    }

    private Node traditionalReversal(Node head) {
        int indexOfLast = size - 1;
        Node temp = new Node(null, null);
        Node newLast = temp;
        while (indexOfLast >= 0) {
            Node current = find(indexOfLast);
            indexOfLast--;
            newLast.next = current;
            newLast = newLast.next;
        }
        return temp.next;
    }

    @Override
    public void reverse() {
        if (first == null || last == null) {
            return;
        }
        last = first;
        first = traditionalReversal(first);
        last.next = null;
    }

    @Override
    public String toString() {
        return first.toString();
    }
}
