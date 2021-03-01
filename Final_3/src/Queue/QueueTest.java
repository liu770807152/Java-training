package Queue;

import Queue.Queue;
import Queue.QueueTest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class QueueTest {
    private boolean ArrayQueue = true;

    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    static class Thing {
        final String name;

        public Thing(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Thing " + name;
        }
    }

    @Test
    public void testPushNotEmpty() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Assert.assertTrue("Newly created Queue should be empty!", Queue.isEmpty());
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        assertFalse("Queue should not be empty after one push", Queue.isEmpty());
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        assertFalse("Queue should not be empty after two pushes", Queue.isEmpty());
    }

    @Test
    public void testPushTwoString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        checkToString(Queue, "");
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        checkToString(Queue, "Thing One");
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        checkToString(Queue, "Thing One Thing Two");
    }

    private <T> void checkToString(Queue<T> Queue, String expected) {
        Assert.assertTrue("Incorrect output from toString().  Expected \"" + expected + "\" but got \"" + Queue.toString() + "\"", expected.equals(Queue.toString()));
    }

    @Test
    public void testPopOne() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thingToDo = new Thing("to do");
        Queue.push(thingToDo);
        checkPop(Queue, thingToDo);
        Assert.assertTrue("Queue should be empty after one push and one pop", Queue.isEmpty());
    }

    @Test
    public void testPopOneString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thingToDo = new Thing("to do");
        Queue.push(thingToDo);
        Thing thingToSee = new Thing("to see");
        Queue.push(thingToSee);
        Queue.pop();
        checkToString(Queue, "Thing to see");
    }

    @Test
    public void testPopTwo() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        checkPop(Queue, thing1);
        assertFalse("Queue should be empty after two pushes and one pop", Queue.isEmpty());
        checkPop(Queue, thing2);
        Assert.assertTrue("Queue should be empty after two pushes and two pops", Queue.isEmpty());
    }

    @Test
    public void testPopTwoString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        Queue.pop();
        Queue.pop();
        checkToString(Queue, "");
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopEmpty() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Queue.pop();
    }

    @Test
    public void testEmptyString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        checkToString(Queue, "");
    }

    @Test
    public void testPeekOne() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thingToEat = new Thing("to eat");
        Queue.push(thingToEat);
        Thing v = Queue.peek();
        Assert.assertTrue("Queue.peek() returned " + v + ", expected " + thingToEat, thingToEat == v);
        assertFalse("Queue should notbe empty after one push and one pop", Queue.isEmpty());
    }

    @Test
    public void testMultiplePush() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        Queue.push(thing2);
        checkPop(Queue, thing1);
        checkPop(Queue, thing2);
        checkPop(Queue, thing2);
    }

    @Test
    public void testMultiplePushString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        checkToString(Queue, "Thing One Thing Two");
        Queue.push(thing2);
        checkToString(Queue, "Thing One Thing Two Thing Two");
        Queue.pop();
        checkToString(Queue, "Thing Two Thing Two");
        Queue.pop();
        checkToString(Queue, "Thing Two");
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Queue.peek();
    }

    @Test
    public void testNoMemoryLeaks() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Queue.push(thing1);
        WeakReference<Thing> reference1 = new WeakReference<>(thing1);
        Thing thing2 = new Thing("Two");
        Queue.push(thing2);
        WeakReference<Thing> reference2 = new WeakReference<>(thing2);
        checkPop(Queue, thing1);
        checkPop(Queue, thing2);
        thing1 = null;
        thing2 = null;

        Runtime.getRuntime().gc();
        assertNull("A reference still exists to thing1 somewhere in the Queue!", reference1.get());
        assertNull("A reference still exists to thing2 somewhere in the Queue!", reference2.get());
    }

    @Test
    public void testPushPopLarge() {
        Queue<String> Queue = ArrayQueue ? new ArrayQueue<String>() : new LinkedQueue<String>();
        List<String> range = IntStream.range(0, 500).boxed().map(i -> String.valueOf(i)).collect(Collectors.toList());
        List<String> rangeForTest = IntStream.range(0, 500).boxed().map(i -> String.valueOf(i)).collect(Collectors.toList());
        testRecursive(range, rangeForTest, Queue);
    }

    private void testRecursive(List<String> values, List<String> testValues, Queue<String> Queue) {
        String v = values.remove(0);
        Queue.push(v);
        assertFalse("Queue should not be empty after pushing " + v, Queue.isEmpty());
        if (!values.isEmpty()) {
            testRecursive(values, testValues, Queue);
        }
        String result = Queue.pop();
        String t = testValues.remove(0);
        Assert.assertTrue("Queue.pop() returned " + result + ", expected " + t, t.equals(result));
    }

    @Test
    public void testContainsTop() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("Queue.contains(thing1) returned true, expected false", Queue.contains(thing1));
        assertFalse("Queue.contains(thing2) returned true, expected false", Queue.contains(thing2));
        Queue.push(thing1);
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing1));
        Queue.push(thing2);
        Assert.assertTrue("Queue.contains(thing2) returned false, expected true", Queue.contains(thing2));
        Queue.pop();
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing2));
        Queue.pop();
        assertFalse("Queue.contains(thing1) returned true, expected false", Queue.contains(thing1));
        assertFalse("Queue.contains(null) returned true, expected false", Queue.contains(null));
    }

    @Test
    public void testContainsBuried() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("Queue.contains(thing1) returned true, expected false", Queue.contains(thing1));
        assertFalse("Queue.contains(thing2) returned true, expected false", Queue.contains(thing2));
        Queue.push(thing1);
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing1));
        assertFalse("Queue.contains(thing2) returned true, expected false", Queue.contains(thing2));
        Queue.push(thing2);
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing1));
        Assert.assertTrue("Queue.contains(thing2) returned false, expected true", Queue.contains(thing2));
        Queue.pop();
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing2));
        assertFalse("Queue.contains(thing2) returned true, expected false", Queue.contains(thing1));
        Queue.pop();
        assertFalse("Queue.contains(thing1) returned true, expected false", Queue.contains(thing1));
        assertFalse("Queue.contains(thing2) returned true, expected false", Queue.contains(thing2));
    }

    @Test
    public void testContainsDuplicateRemoved() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        Queue.push(thing1);
        Queue.push(thing2);
        Queue.push(thing1);
        Queue.pop();
        Assert.assertTrue("Queue.contains(thing1) returned false, expected true", Queue.contains(thing1));
    }

    @Test
    public void testPopEmptyString() {
        Queue<Thing> Queue = ArrayQueue ? new ArrayQueue<Thing>() : new LinkedQueue<Thing>();
        Thing thingvellir = new Thing("vellir");
        Queue.push(thingvellir);
        Queue.pop();
        try {
            Queue.pop();
        } catch (NoSuchElementException e) {
            // ignore the exception
        }
        checkToString(Queue, "");
        Queue.push(thingvellir);
        checkToString(Queue, "Thing vellir");
    }

    @Test
    public void testContainsDeep() {
        final int SIZE = 874;
        Queue<String> Queue = ArrayQueue ? new ArrayQueue<String>() : new LinkedQueue<String>();
        for (int i = 0; i < SIZE; i++) {
            Queue.push(String.valueOf(i));
        }
        assertFalse("Queue.contains(null) returned true, expected false", Queue.contains(null));
        for (int i = 0; i < SIZE; i++) {
            Assert.assertTrue("Queue.contains(\"" + i + "\") returned false, expected true", Queue.contains(String.valueOf(i)));
        }
    }

    private void checkPop(Queue<Thing> Queue, Thing expected) {
        Thing result = Queue.pop();
        Assert.assertTrue("Queue.pop() returned " + result + ", expected " + expected, expected == result);
    }
}
