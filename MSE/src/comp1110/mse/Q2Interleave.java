package comp1110.mse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * COMP1110 Mid-Semester Exam, Question 2
 */
public class Q2Interleave {

    /**
     * This function takes two arrays of strings and returns a new array of strings where
     * the elements from a and b are interleaved.
     * For example:
     *    a = {"a", "b", "c", "d"}
     *    b = {"e", "f", "g", "h"}
     * the result will be
     *        {"a", "e", "b", "f", "c", "g", "d", "h"}
     * in the case where one array is longer than the other, the remaining elements
     * will be added to the end of the result:
     *    a = {"a", "b", "c"}
     *    b = {"e"}
     * the result will be
     *        {"a", "e", "b", "c"}
     */
    public static String[] interleave(String[] a, String[] b) {
        if (a.length == 0) {
            return b;
        } else if (b.length == 0) {
            return a;
        }

        String[] result = new String[a.length + b.length];
        int length = Math.min(a.length, b.length);
        int index = 0;

        // 1. 交错穿插
        for (; index < length; index++) {
            result[index*2] = a[index];
            result[index*2+1] = b[index];
        }

        // 2. 添加剩余
        if (a.length != b.length) {
            while (index * 2 < a.length + b.length) {
                int i = index * 2;
                if (length < b.length) {
                    result[i] = b[index];
                    result[i + 1] = b[++index];
                } else {
                    result[i] = a[index];
                    result[i + 1] = a[++index];
                }
            }
        }

        return result;
    }

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
        if (c.length != r.length) {
            assertTrue("Expected '{"+cs+"}' but got '{"+rs+"}'", false);
        } else {
            boolean match = true;
            for (int i = 0; i < c.length; i++) {
                if (!c[i].equals(r[i])) {
                    match = false;
                }
            }
            assertTrue("Expected '{"+cs+"}' but got '{"+rs+"}'", match);
        }
    }
}
