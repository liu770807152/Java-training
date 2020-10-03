package fourthLec;

public class ReverseLinkedList {
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

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, null);
        root.next = new ListNode(2, null);
        root.next.next = new ListNode(3, null);
        System.out.println(root);

        root = reverse(root);
        System.out.println(root);
    }
}
