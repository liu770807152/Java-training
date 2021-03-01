import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MergeSortSteve {
    static List<Integer> mergeSort(List<Integer> in) {
        if (in == null || in.size() <= 1) {
            return in;
        }

        int size = in.size();
        List<Integer> l = mergeSort (in.subList(0, size/2));
        List<Integer> r = mergeSort (in.subList(size/2, size));

        int lf = 0;
        int rf = 0;
        List<Integer> result = new ArrayList<>(size);

        while (lf < l.size() || rf < r.size()) {
            if (lf == l.size() || (rf < r.size() && r.get(rf) < l.get(lf))) {
                result.add(r.get(rf++));
            } else {
                result.add(l.get(lf++));
            }
        }
        return result;
    }

    @Test
    public void testSort() {
        Integer[] single = { 7 };
        Integer[] sorted = { 1, 2, 3, 6, 8, 11 };
        Integer[] unsorted = { 11, 6, 1, 2, 3, 8 };

        assertEquals(Arrays.asList(single), mergeSort(Arrays.asList(single)));
        assertEquals(Arrays.asList(sorted), mergeSort(Arrays.asList(unsorted)));

    }
}