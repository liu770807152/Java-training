package Map;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;

public class MapTest {
    private static final boolean HASH_MAP = true;
    @Test
    public void testPut() {
        // only assume that size() works, and toString() works
        Map<String, Integer> map = HASH_MAP ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        assertTrue(map.size() == 0);
        map.put("Alice", 19);
        assertTrue(map.size() == 1);
        System.out.println(map);
        assertTrue(map.toString().equals("(Alice, 19)"));
        map.put("Alice", 18);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 18)"));
        map.put("Bob", 20);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 18), (Bob, 20)") || map.toString().equals("(Bob, 20), (Alice, 18)"));
        map.put("Bob", 19);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 18), (Bob, 19)") || map.toString().equals("(Bob, 19), (Alice, 18)"));
        map.put("Cindy", 21);
        assertTrue(map.size() == 3);
        map.put("Cindy", 20);
        assertTrue(map.size() == 3);
    }

    @Test
    public void testPutNull() {
        // only assume that size() works, and toString() works
        Map<String, Integer> map = HASH_MAP ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        assertTrue(map.size() == 0);
        map.put(null, 1);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(null, 1)"));
        map.put(null, 0);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(null, 0)"));
        map.put("Bob", 20);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(null, 0), (Bob, 20)") || map.toString().equals("(Bob, 20), (null, 0)"));
        map.put("Bob", 21);
        System.out.println(map.size());
        System.out.println(map);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(null, 0), (Bob, 21)") || map.toString().equals("(Bob, 21), (null, 0)"));
        map.put("Cindy", 20);
        assertTrue(map.size() == 3);
        map.put("Cindy", 22);
        assertTrue(map.size() == 3);
    }


    @Test
    public void testGet() {
        // only assume that size() works, toString() works, and add() works
        Map<String, Integer> map = HASH_MAP ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        assertTrue(map.size() == 0);
        map.put("Alice", 19);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 19)"));
        assertTrue(map.get("Alice") == 19);
        assertNull(map.get("Bob"));
        map.put("Alice", 18);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 18)"));
        map.put("Bob", 19);
        assertTrue(map.get("Alice") == 18);
        assertTrue(map.get("Bob") == 19);
        assertNull(map.get("Cindy"));

        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 18), (Bob, 19)") || map.toString().equals("(Bob, 19), (Alice, 18)"));
        map.put("Bob", 21);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 18), (Bob, 21)") || map.toString().equals("(Bob, 21), (Alice, 18)"));
        map.put("Cindy", 22);
        assertTrue(map.get("Alice") == 18);
        assertTrue(map.get("Bob") == 21);
        assertTrue(map.get("Cindy") == 22);
        assertTrue(map.size() == 3);
        map.put("Cindy", 21);
        assertTrue(map.size() == 3);
    }

    @Test
    public void testRemove() {
        // only assume that size() works, toString() works, add() works and contains() works
        Map<String, Integer> map = HASH_MAP ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        assertTrue(map.size() == 0);
        map.put("Alice", 19);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 19)"));
        assertTrue(map.get("Alice") == 19);
        assertNull(map.get("Bob"));
        map.remove("Alice");
        map.remove("Bob");
        map.remove("Cindy");
        assertTrue(map.size() == 0);
        assertNull(map.get("Bob"));
        assertNull(map.get("Alice"));
        map.put("Alice", 19);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 19)"));
        map.put("Alice", 20);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 20)"));
        map.put("Bob", 19);
        assertTrue(map.get("Alice") == 20);
        assertTrue(map.get("Bob") == 19);
        assertNull(map.get("Cindy"));

        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 20), (Bob, 19)") || map.toString().equals("(Bob, 19), (Alice, 20)"));
        map.put("Bob", 20);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Alice, 20), (Bob, 20)") || map.toString().equals("(Bob, 20), (Alice, 20)"));

        // set.remove("Alice");
        map.remove("Bob");
        map.remove("Cindy");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 20)"));
        map.put("Bob", 20);
        assertTrue(map.get("Alice") == 20);
        assertTrue(map.get("Bob") == 20);
        assertNull(map.get("Cindy"));

        map.put("Cindy", 20);
        assertTrue(map.get("Alice") == 20);
        assertTrue(map.get("Bob") == 20);
        assertTrue(map.get("Cindy") == 20);
        assertTrue(map.size() == 3);
        map.put("Cindy", 23);
        assertTrue(map.size() == 3);
        // set.remove("Alice");
        map.remove("Bob");
        map.remove("Cindy");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Alice, 20)"));
        map.put("Bob", 20);
        map.put("Cindy", 20);
        assertTrue(map.get("Alice") == 20);
        assertTrue(map.get("Bob") == 20);
        assertTrue(map.get("Cindy") == 20);
    }

}
