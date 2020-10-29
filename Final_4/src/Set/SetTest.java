package Set;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class SetTest {
    private final boolean USE_HASH = true;

    @Test
    public void testAdd() {
        Set<String> set = USE_HASH ? new HashSet<String>() : new BSTSet<String>();
        set.add("Bob");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Bob"));
        set.add("Mary");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Bob, Mary") || set.toString().equals("Mary, Bob"));
        set.add("Mary");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Bob, Mary") || set.toString().equals("Mary, Bob"));
    }

    @Test
    public void testRemove() {
        Set<String> set = USE_HASH ? new HashSet<String>() : new BSTSet<String>();
        set.add("Bob");
        set.add("Mary");
        set.remove("Mary");
        assertTrue(set.size() == 1);
        System.out.println(set);
        assertTrue(set.toString().equals("Bob"));

        set.add("Mary");
        set.add("Fred");
        set.remove("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Fred, Mary") || set.toString().equals("Mary, Fred"));
        set.add("Sue");
        set.remove("Mary");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Fred, Sue") || set.toString().equals("Sue, Fred"));
        set.remove("Fred");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Sue"));
        set.remove("Fred");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Sue"));
    }

    @Test
    public void testContains() {
        Set<String> set = USE_HASH ? new HashSet<String>() : new BSTSet<String>();
        set.add("Bob");
        set.add("Mary");
        set.add("Fred");
        assertTrue(set.contains("Bob") && set.contains("Fred") && set.contains("Mary"));
        assertFalse(set.contains("Sue"));
        set.remove("Bob");
        assertFalse(set.contains("Bob"));
    }
}
