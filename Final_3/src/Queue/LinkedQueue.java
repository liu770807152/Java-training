package Queue;

import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T>{

    class Node {
        private T data;
        private Node next;

        Node(T value, Node next) {
            this.data = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (Node temp = this; temp != null; temp = temp.next) {
                if (temp.data != null) {
                    result.append(temp.data + " ");
                }
            }
            return result.length() == 0 ? "" : result.deleteCharAt(result.length() - 1).toString();
        }
    }

    /**
     * 指向队头和队尾的结点
     * front == null && rear == null时,队列为空
     */
    private Node front,rear;

    private int size;

    public LinkedQueue(){
        //初始化队列
        this.front = this.rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    /**
     * data 入队,添加成功返回true,否则返回false,可扩容
     * @param data
     * @return
     */
    @Override
    public void  push(T data) {
        Node q = new Node(data,null);
        if (this.front == null) { // 空队列插入
            this.front = q;
        } else { // 非空队列, 尾部插入
            this.rear.next = q;
        }
        this.rear = q;
        size++;
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.front.data;
    }

    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()){
            throw new NoSuchElementException("The LinkedQueue is empty");
        }
        T x = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--;
        return x;
    }

    /**
     * 是否包含某元素
     */
    @Override
    public boolean contains(T data) {
        if (data == null || this.isEmpty()) {
            return false;
        }
        Node temp = this.front;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.front == null ? "" : this.front.toString();
    }
}
