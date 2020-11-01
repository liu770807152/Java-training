package Queue;

public interface Queue<T> {
    /**
     * 返回队列长度
     */
    int size();

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();

    /**
     * data 入队,添加成功返回true,否则返回false,可扩容
     * @param data
     */
    void push(T data);

    /**
     * 返回队头元素,不执行删除操作,若队列为空,返回null
     */
    T peek();

    /**
     * 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     */
    T pop();

    /**
     * 是否包含某元素
     */
    boolean  contains(T data);

    @Override
    String toString();
}
