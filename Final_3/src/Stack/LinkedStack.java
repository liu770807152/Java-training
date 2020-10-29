package Stack;


import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
    private Node top;

    private int size;

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
                if (temp.value != null) {
                    result.append(temp.value + " ");
                }
            }
            return result.length() == 0 ? "" : result.deleteCharAt(result.length() - 1).toString();
        }
    }

    public LinkedStack() {
        this.top = new Node(null, null);
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return top == null || top.value == null;
    }

    @Override
    public void push(T data) {
        if (data == null) {
            throw new NullPointerException("data can\'t be null");
        }
        if (this.top == null) {//调用pop()后top可能为null
            this.top = new Node(data, null);
        } else if (this.top.value == null) {
            this.top.value = data;
        } else {
            Node p = new Node(data, this.top);
            top = p;//更新栈顶
        }
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.value;
        top = top.next;
        size--;
        return data;
    }

    /**
     * 是否包含某元素
     *
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) {
        if (data == null || this.isEmpty()) {
            return false;
        }
        Node temp = this.top;
        while (temp != null) {
            if (temp.value.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.top == null ? "" : this.top.toString();
    }
}
