package List;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ListTest {
    private boolean arrayList = false;


    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyGet() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyRemove() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.remove(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeGet() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.get(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeRemove() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.remove(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOverflowGet() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.get(1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOverflowRemove() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.remove(1);
    }
    @Test
    public void testAdd() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        assertTrue(l.size() == 0);
        l.add("a");
        assertTrue(l.size() == 1);
        l.add("bb");
        assertTrue(l.size() == 2);
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));

    }

    @Test
    public void testRemove() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.remove(1);
        assertTrue(l.size() == 2);
        assertTrue(l.toString().equals("a ccc"));
        l.remove(1);
        assertTrue(l.size() == 1);
        assertTrue(l.toString().equals("a"));
        l.remove(0);
        assertTrue(l.size() == 0);
    }

    @Test
    public void testGet() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.get(0).equals("a"));
        assertTrue(l.get(1).equals("bb"));
        assertTrue(l.get(2).equals("ccc"));
    }

    @Test
    public void testReverse() {
        List<String> l = arrayList ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.reverse();
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("ccc bb a"));
        l.reverse();
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.add("dddd");
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("a bb ccc dddd"));
        l.reverse();
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("dddd ccc bb a"));
        l.reverse();
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("a bb ccc dddd"));

    }
}
