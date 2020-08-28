package comp1110.mse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Q2InterleaveTest {

    @Test
    public void testOne() {
        String[] a = {"a"};
        String[] b = {"b"};
        String[] c = {"a", "b"};
        test(a, b, c);
     }

    @Test
    public void testTwo() {
        String[] a = {"a", "b"};
        String[] b = {"c", "d"};
        String[] c = {"a", "c", "b", "d"};
        test(a, b, c);
    }

    @Test
    public void testUnevenR() {
        String[] a = {"a", "b", "c", "d"};
        String[] b = {"e", "f"};
        String[] c = {"a", "e", "b", "f", "c", "d"};
        test(a, b, c);
    }

    @Test
    public void testUnevenL() {
        String[] a = {"a", "b"};
        String[] b = {"c", "d", "e", "f"};
        String[] c = {"a", "c", "b", "d", "e", "f"};
        test(a, b, c);
    }

    @Test
    public void testNoL() {
        String[] a = {"a", "b", "c", "d"};
        String[] b = {};
        String[] c = {"a", "b", "c", "d"};
        test(a, b, c);
    }

    private void test(String[] a, String[] b, String[] c) {
        String [] r = Q2Interleave.interleave(a,b);
        String rs = "";
        for (int i = 0; i < r.length; i++) {
            rs += ((i!= 0) ? ", ": "")+"\""+r[i]+"\"";
        }
        String cs = "";
        for (int i = 0; i < c.length; i++) {
            cs += ((i!= 0) ? ", ": "")+"\""+c[i]+"\"";
        }
        if (c.length != r.length)
            assertTrue("Expected '{"+cs+"}' but got '{"+rs+"}'", false);
        else {
            boolean match = true;
            for (int i = 0; i < c.length; i++) {
                if (!c[i].equals(r[i])) match = false;
            }
            assertTrue("Expected '{"+cs+"}' but got '{"+rs+"}'", match);
        }
    }
}
