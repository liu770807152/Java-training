package TreeSet;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetTest {
    private static final boolean HASH_SET = false;
    @Test
    public void testAdd() {
        // only assume that size() works, and toString() works
        Set<String> set = HASH_SET ? new HashSet<String>() : new TreeSet<String>();
        assertTrue(set.size() == 0);
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.add("Cindy");
        assertTrue(set.size() == 3);
        set.add("Cindy");
        assertTrue(set.size() == 3);
    }

    @Test
    public void testAddNull() {
        // only assume that size() works, and toString() works
        Set<String> set = HASH_SET ? new HashSet<String>() : new TreeSet<String>();
        assertTrue(set.size() == 0);
        set.add(null);
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("null"));
        set.add(null);
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("null"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("null, Bob") || set.toString().equals("Bob, null"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("null, Bob") || set.toString().equals("Bob, null"));
        set.add("Cindy");
        assertTrue(set.size() == 3);
        set.add("Cindy");
        assertTrue(set.size() == 3);
    }


    @Test
    public void testContains() {
        // only assume that size() works, toString() works, and add() works
        Set<String> set = HASH_SET ? new HashSet<String>() : new TreeSet<String>();
        assertTrue(set.size() == 0);
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        assertTrue(set.contains("Alice"));
        assertFalse(set.contains("Bob"));
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.add("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
        assertTrue(set.size() == 3);
        set.add("Cindy");
        assertTrue(set.size() == 3);
    }

    @Test
    public void testRemove() {
        // only assume that size() works, toString() works, add() works and contains() works
        Set<String> set = HASH_SET ? new HashSet<String>() : new TreeSet<String>();
        assertTrue(set.size() == 0);
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        assertTrue(set.contains("Alice"));
        assertFalse(set.contains("Bob"));
        set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 0);
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.add("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));

        // set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        set.add("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
        assertTrue(set.size() == 3);
        set.add("Cindy");
        assertTrue(set.size() == 3);
        // set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.add("Bob");
        set.add("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
    }
}
