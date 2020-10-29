package Stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    /**
     * 栈顶指针,-1代表空栈
     */
    private int top = -1;

    /**
     * 容量大小默认为2
     */
    private int capacity = 2;

    private final double GROWTH_RATE = 1.5;

    /**
     * 存放元素的数组
     */
    private T[] array = (T[]) new Object[this.capacity];

    private int size;

    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public ArrayStack() {
        array = (T[]) new Object[this.capacity];
    }

    @Override
    public int size() {
        return size;
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


    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 添加元素,从栈顶(数组尾部)插入
     *
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
        //从栈顶添加元素
        array[++top] = data;

        size++;
    }

    /**
     * 获取栈顶元素的值,不删除
     *
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    /**
     * 从栈顶(顺序表尾部)删除
     *
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        T data = array[top--];
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        this.array = temp;
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
            for (int i = this.size - 1; i >= 0; i--) {
                result.append (this.array[i] + " ");
            }
            return result.deleteCharAt (result.length () - 1).toString ();
        }
    }
}
