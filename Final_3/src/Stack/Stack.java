package Stack;

public interface Stack<T> {

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 栈的元素数量
     * @return
     */
    int size();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();

    /**
     * 是否包含某元素
     * @return
     */
    boolean contains(T data);

    @Override
    String toString();
}
