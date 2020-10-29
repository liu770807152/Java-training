package Map;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MapTest {
    boolean USE_HASH = true;


    @Test
    public void testPut() {
        Map<String, Integer> map = USE_HASH ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        map.put("Bob", 19);
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Bob, 19)"));
        map.put("Mary", 21);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Bob, 19), (Mary, 21)") || map.toString().equals("(Mary, 21), (Bob, 19)"));
        map.put("Mary", 20);
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Bob, 19), (Mary, 20)") || map.toString().equals("(Mary, 20), (Bob, 19)"));
    }


    @Test
    public void testRemove() {
        Map<String, Integer> map = USE_HASH ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        map.put("Bob", 19);
        map.put("Mary", 21);
        map.remove("Mary");
        assertTrue(map.size() == 1);
        System.out.println(map);
        assertTrue(map.toString().equals("(Bob, 19)"));

        map.put("Mary", 21);
        map.put("Fred", 20);
        map.remove("Bob");
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Fred, 20), (Mary, 21)") || map.toString().equals("(Mary, 21), (Fred, 20)"));
        map.put("Sue", 22);
        map.remove("Mary");
        assertTrue(map.size() == 2);
        assertTrue(map.toString().equals("(Fred, 20), (Sue, 22)") || map.toString().equals("(Sue, 22), (Fred, 20)"));
        map.remove("Fred");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Sue, 22)"));
        map.remove("Fred");
        assertTrue(map.size() == 1);
        assertTrue(map.toString().equals("(Sue, 22)"));
    }

    @Test
    public void testGet() {
        Map<String, Integer> map = USE_HASH ? new HashMap<String, Integer>() : new BSTMap<String, Integer>();
        map.put("Bob", 19);
        map.put("Mary", 21);
        map.put("Fred", 20);
        assertTrue(map.get("Bob") == 19 && map.get("Fred") == 20 && map.get("Mary") == 21);
        assertTrue(map.get("Sue") == null);
        map.remove("Bob");
        assertTrue(map.get("Bob") == null);
    }
}
