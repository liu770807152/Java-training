package fourthLec;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalcuateTest {

    //一个JUnit Rule就是一个实现了TestRule的类，这些类的作用类似于 @Before、@After，是用来在每个测试方法的执行前后执行一些代码的一个方法。
    @Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void add() {
        Calcuate calcuate = new Calcuate();
        int result = calcuate.add(2, 3);
        assertEquals("加法有问题", 5, result);
        /*
         * "加法有问题"：期望值和实际值不一致时，显示的信息
         * 5 ：期望值
         * result ：实际值
         */
    }

    @Test
    public void subtract() {
    }

    @org.junit.Test
    public void multiply() {
        Calcuate calcuate = new Calcuate();
        double result = calcuate.divide(50, 10);
        assertTrue("Expected " + 5 +
                ", but got " + result + "."+"好吧", result == 5);
    }

    @org.junit.Test
    public void divide() {
    }
}