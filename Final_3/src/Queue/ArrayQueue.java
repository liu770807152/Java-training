package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private int front = -1;
    private int rear = -1;

    /**
     * 容量大小默认为2
     */
    private int capacity = 2;

    private final double GROWTH_RATE = 1.5;

    /**
     * 存放元素的数组
     */
    private T[] array;

    private int size;

    public ArrayQueue() {
        array = (T[]) new Object[this.capacity];
    }

    /**
     * 扩容的方法
     *
     * @param capacity
     */
    public void expandCapacity(int capacity) {
        //如果需要拓展的容量比现在数组的容量还小,则无需扩容
        if (capacity < size) {
            return;
        }
        T[] old = array;
        array = (T[]) new Object[capacity];
        //复制元素
        for (int i = 0; i < size; i++) {
            array[i] = old[i];
        }
    }

    /**
     * 返回队列长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    /**
     * 入队,添加成功返回true,否则返回false,可扩容
     * @param data
     */
    @Override
    public void push(T data) {
        //判断容量是否充足
        if (array.length == size) {
            expandCapacity((int) (size * GROWTH_RATE));//扩容
        }
        if (array.length == 0) {
            array = (T[]) new Object[this.capacity];
        }
        //从队尾添加元素
        array[++rear] = data;
        front = 0;
        size++;
    }

    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[front];
    }

    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        rear--;
        T data = array[front];
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i+1];
        }
        this.array = temp;
        // 千万别忘了更新front
        if (this.array.length == 0) {
            front = -1;
        }
        return data;
    }

    /**
     * 是否包含某元素
     */
    @Override
    public boolean contains(T data) {
        if (data == null || this.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            StringBuilder result = new StringBuilder ();
            for (int i = 0; i < this.size; i++) {
                result.append (this.array[i] + " ");
            }
            return result.deleteCharAt (result.length () - 1).toString ();
        }
    }
}
