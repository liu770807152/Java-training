public class IntLinkedList {
    int value;
    IntLinkedList next;

    IntLinkedList(int value) {
        this.value = value;
    }

    void add(int value) {
        if (next == null) // good, we're at the end of the list, so can add another
        {
            next = new IntLinkedList(value);
        } else {
            next.add(value); // OK, just ask next to add it to itself
        }
    }

    @Override
    public String toString() {
        if (next == null) {
            return value + "";
        } else {
            return value + ", " + next;
        }
    }

    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList(5);
        list.add(3);
        list.add(7);
        list.add(13);

        System.out.println("Here it is! "+list);

    }
}
