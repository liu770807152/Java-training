package Stack;

// 后进先出
public interface Stack<T> {

    /**
     * 栈是否为空
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 栈的元素数量
     * @return int
     */
    int size();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素,未出栈
     * @return T
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return T
     */
    T pop();

    /**
     * 是否包含某元素
     * @return boolean
     */
    boolean contains(T data);

    @Override
    String toString();
}
