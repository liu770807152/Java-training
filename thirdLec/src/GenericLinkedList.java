public class GenericLinkedList<T> {
    T value;
    GenericLinkedList next;

    GenericLinkedList(T value) {
        this.value = value;
    }

    void add(T value) {
        if (next == null) // good, we're at the end of the list, so can add another
        {
            next = new GenericLinkedList(value);
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
        GenericLinkedList<Integer> ilist = new GenericLinkedList(5);
        ilist.add(3);
        ilist.add(7);
        ilist.add(13);
        System.out.println("Here it is! "+ilist);

        GenericLinkedList<Double> dlist = new GenericLinkedList(5.0);
        dlist.add(3.0);
        dlist.add(7.0);
        dlist.add(13.1);
        System.out.println("Here it is! "+dlist);

        GenericLinkedList<String> slist = new GenericLinkedList("X");
        slist.add("3.0");
        slist.add("7.0");
        slist.add("foo");
        System.out.println("Here it is! "+slist);
    }
}

