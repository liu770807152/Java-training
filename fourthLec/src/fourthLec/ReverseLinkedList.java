package fourthLec;

public class SwapLinkedList {
    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int num, ListNode next) {
            this.value = num;
            this.next = next;
        }

        @Override
        public String toString() {
            if (this != null) {
                return this.value + " -> " + this.next;
            }
            return "";
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if(head == null || head.next == null){
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, null);
        root.next = new ListNode(2, null);
        root.next.next = new ListNode(3, null);
        System.out.println(root);

        root = swapPairs(root);
        System.out.println(root);
    }
}
