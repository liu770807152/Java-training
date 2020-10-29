package Stack;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.ref.WeakReference;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class StackTest {
    private boolean ArrayStack = false;

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
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Assert.assertTrue("Newly created stack should be empty!", stack.isEmpty());
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        assertFalse("Stack should not be empty after one push", stack.isEmpty());
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        assertFalse("Stack should not be empty after two pushes", stack.isEmpty());
    }

    @Test
    public void testPushTwoString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        checkToString(stack, "");
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        checkToString(stack, "Thing One");
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        checkToString(stack, "Thing Two Thing One");
    }

    private <T> void checkToString(Stack<T> stack, String expected) {
        Assert.assertTrue("Incorrect output from toString().  Expected \"" + expected + "\" but got \"" + stack.toString() + "\"", expected.equals(stack.toString()));
    }

    @Test
    public void testPopOne() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thingToDo = new Thing("to do");
        stack.push(thingToDo);
        checkPop(stack, thingToDo);
        Assert.assertTrue("Stack should be empty after one push and one pop", stack.isEmpty());
    }

    @Test
    public void testPopOneString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thingToDo = new Thing("to do");
        stack.push(thingToDo);
        Thing thingToSee = new Thing("to see");
        stack.push(thingToSee);
        stack.pop();
        checkToString(stack, "Thing to do");
    }

    @Test
    public void testPopTwo() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        checkPop(stack, thing2);
        assertFalse("Stack should be empty after two pushes and one pop", stack.isEmpty());
        checkPop(stack, thing1);
        Assert.assertTrue("Stack should be empty after two pushes and two pops", stack.isEmpty());
    }

    @Test
    public void testPopTwoString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        stack.pop();
        stack.pop();
        checkToString(stack, "");
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmpty() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        stack.pop();
    }

    @Test
    public void testEmptyString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        checkToString(stack, "");
    }

    @Test
    public void testPeekOne() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thingToEat = new Thing("to eat");
        stack.push(thingToEat);
        Thing v = stack.peek();
        Assert.assertTrue("stack.peek() returned " + v + ", expected " + thingToEat, thingToEat == v);
        assertFalse("Stack should notbe empty after one push and one pop", stack.isEmpty());
    }

    @Test
    public void testPeekTwo() {
        Stack<String> stack = ArrayStack ? new ArrayStack<String>() : new LinkedStack<String>();
        String a = "a";
        stack.push(a);
        String b = "b";
        stack.push(b);
        String v1 = stack.peek();
        Assert.assertTrue("stack.peek() returned " + v1 + ", expected " + b, b.equals(v1));
        assertFalse("Stack should be empty after two pushes and one peek", stack.isEmpty());
        String v2 = stack.peek();
        Assert.assertTrue("stack.peek() returned " + v2 + ", expected " + b, b.equals(v2));
        assertFalse("Stack should be empty after two pushes and two peeks", stack.isEmpty());
        stack.pop(); // throw away top value
        String v3 = stack.peek();
        Assert.assertTrue("stack.peek() returned " + v3 + ", expected " + a, a.equals(v3));
    }

    @Test
    public void testMultiplePush() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        stack.push(thing2);
        checkPop(stack, thing2);
        checkPop(stack, thing2);
        checkPop(stack, thing1);
    }

    @Test
    public void testMultiplePushString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        checkToString(stack, "Thing Two Thing One");
        stack.push(thing2);
        checkToString(stack, "Thing Two Thing Two Thing One");
        stack.pop();
        checkToString(stack, "Thing Two Thing One");
        stack.pop();
        checkToString(stack, "Thing One");
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmpty() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        stack.peek();
    }

    @Test
    public void testNoMemoryLeaks() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        stack.push(thing1);
        WeakReference<Thing> reference1 = new WeakReference<>(thing1);
        Thing thing2 = new Thing("Two");
        stack.push(thing2);
        WeakReference<Thing> reference2 = new WeakReference<>(thing2);
        checkPop(stack, thing2);
        checkPop(stack, thing1);
        thing1 = null;
        thing2 = null;

        Runtime.getRuntime().gc();
        assertNull("A reference still exists to thing1 somewhere in the stack!", reference1.get());
        assertNull("A reference still exists to thing2 somewhere in the stack!", reference2.get());
    }

    @Test
    public void testPushPopLarge() {
        Stack<String> stack = ArrayStack ? new ArrayStack<String>() : new LinkedStack<String>();
        List<String> range = IntStream.range(0, 500).boxed().map(i -> String.valueOf(i)).collect(Collectors.toList());
        testRecursive(range, stack);
    }

    private void testRecursive(List<String> values, Stack<String> stack) {
        String v = values.remove(0);
        stack.push(v);
        assertFalse("Stack should not be empty after pushing " + v, stack.isEmpty());
        if (!values.isEmpty()) {
            testRecursive(values, stack);
        }
        String result = stack.pop();
        Assert.assertTrue("stack.pop() returned " + result + ", expected " + v, v.equals(result));
    }

    @Test
    public void testContainsTop() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("stack.contains(thing1) returned true, expected false", stack.contains(thing1));
        assertFalse("stack.contains(thing2) returned true, expected false", stack.contains(thing2));
        stack.push(thing1);
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
        stack.push(thing2);
        Assert.assertTrue("stack.contains(thing2) returned false, expected true", stack.contains(thing2));
        stack.pop();
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
        stack.pop();
        assertFalse("stack.contains(thing1) returned true, expected false", stack.contains(thing1));
        assertFalse("stack.contains(null) returned true, expected false", stack.contains(null));
    }

    @Test
    public void testContainsBuried() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        assertFalse("stack.contains(thing1) returned true, expected false", stack.contains(thing1));
        assertFalse("stack.contains(thing2) returned true, expected false", stack.contains(thing2));
        stack.push(thing1);
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
        assertFalse("stack.contains(thing2) returned true, expected false", stack.contains(thing2));
        stack.push(thing2);
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
        Assert.assertTrue("stack.contains(thing2) returned false, expected true", stack.contains(thing2));
        stack.pop();
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
        assertFalse("stack.contains(thing2) returned true, expected false", stack.contains(thing2));
        stack.pop();
        assertFalse("stack.contains(thing1) returned true, expected false", stack.contains(thing1));
        assertFalse("stack.contains(thing2) returned true, expected false", stack.contains(thing2));
    }

    @Test
    public void testContainsDuplicateRemoved() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thing1 = new Thing("One");
        Thing thing2 = new Thing("Two");
        stack.push(thing1);
        stack.push(thing2);
        stack.push(thing1);
        stack.pop();
        Assert.assertTrue("stack.contains(thing1) returned false, expected true", stack.contains(thing1));
    }

    @Test
    public void testPopEmptyString() {
        Stack<Thing> stack = ArrayStack ? new ArrayStack<Thing>() : new LinkedStack<Thing>();
        Thing thingvellir = new Thing("vellir");
        stack.push(thingvellir);
        stack.pop();
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            // ignore the exception
        }
        checkToString(stack, "");
        stack.push(thingvellir);
        checkToString(stack, "Thing vellir");
    }

    @Test
    public void testContainsDeep() {
        final int SIZE = 874;
        Stack<String> stack = ArrayStack ? new ArrayStack<String>() : new LinkedStack<String>();
        for (int i = 0; i < SIZE; i++) {
            stack.push(String.valueOf(i));
        }
        assertFalse("stack.contains(null) returned true, expected false", stack.contains(null));
        for (int i = 0; i < SIZE; i++) {
            Assert.assertTrue("stack.contains(\"" + i + "\") returned false, expected true", stack.contains(String.valueOf(i)));
        }
    }

    private void checkPop(Stack<Thing> stack, Thing expected) {
        Thing result = stack.pop();
        Assert.assertTrue("stack.pop() returned " + result + ", expected " + expected, expected == result);
    }
}
