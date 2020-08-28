package comp1110.mse;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Q3PlaneTest {
    static final int DEFAULT_ITERATIONS = 10;

    @Test
    public void testGetSpeed() {
        Random r = new Random();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            String name = "NA"+r.nextInt(10000);
            int speed = 600+r.nextInt(400);
            Q3Plane p = new Q3Plane(name, speed);
            int s = p.getSpeed();
            assertTrue("Expected speed of '"+speed+"', but got '"+s+"'", s == speed );
        }
     }

    @Test
    public void testSetSpeed() {
        Random r = new Random();
        String name = "NA"+r.nextInt(10000);
        int speed = 600+r.nextInt(400);
        Q3Plane p = new Q3Plane(name, speed);
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            speed = 600+r.nextInt(400);
            p.resetSpeed(speed);
            int s = p.getSpeed();
            assertTrue("Expected speed of '"+speed+"', but got '"+s+"'", s == speed );
        }
    }

    @Test
    public void testTimeToTravel() {
        Random r = new Random();
        String name = "NA"+r.nextInt(10000);
        int s = 600+r.nextInt(400);
        Q3Plane p = new Q3Plane(name, s);
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            s = 600+r.nextInt(400);
            int d = 300+r.nextInt(500);
            p.resetSpeed(s);
            int t = p.timeToTravel(d);
            int rt = (60 * d) / s;
            assertTrue("Expected time of '"+rt+"', but got '"+t+"'", t == rt );
        }
    }

    @Test
    public void testToString() {
        Random r = new Random();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            String name = "NA"+r.nextInt(10000);
            int s = 600+r.nextInt(400);
            Q3Plane p = new Q3Plane(name, s);
            String ref = "Plane "+name+" is travelling "+s+" km/h";
            String res = p.toString();
            assertTrue("Expected string '"+ref+"', but got '"+res+"'", ref.equals(res));
        }
    }

    @Test
    public void testToStringTwo() {
        Random r = new Random();
        String name = "NA"+r.nextInt(10000);
        String name2 = "NA"+r.nextInt(10000);
        int s = 600+r.nextInt(400);
        int s2 = 600+r.nextInt(400);
        Q3Plane p = new Q3Plane(name, s);
        Q3Plane p2 = new Q3Plane(name2, s2);

        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            s = 600+r.nextInt(400);
            p.resetSpeed(s);
            String ref = "Plane "+name+" is travelling "+s+" km/h";
            String res = p.toString();
            assertTrue("Expected string '"+ref+"', but got '"+res+"'", ref.equals(res));
            s2 = 600+r.nextInt(400);
            p2.resetSpeed(s2);
            String ref2 = "Plane "+name2+" is travelling "+s2+" km/h";
            String res2 = p2.toString();
            assertTrue("Expected string '"+ref2+"', but got '"+res2+"'", ref2.equals(res2));
        }
    }

}
