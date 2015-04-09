import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Christopher on 4/8/2015.
 */
public class TurtleTest {

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("-- setUp --");

    }

    @org.junit.Test
    public void testConstruction() throws Exception {
        System.out.println("-- testConstruction --");
        Turtle t = null;
        assertEquals("Turtle not null before instantiation", null, t);
        t = new Turtle();
        assertNotEquals("Turtle null after instantiation", null, t);
    }

    @org.junit.Test
    public void testMove() throws Exception {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        Point p = t.location();
        t.move(1);
        Point p2 = t.location();
        assertNotEquals("Starting point and end point are equal after move.", p, p2);
    }

    @org.junit.Test
    public void testTurn() throws Exception {
        System.out.println("-- testTurn --");
        Turtle t = new Turtle();
    }

    @org.junit.Test
    public void testPenUp() throws Exception {
        System.out.println("-- testPenUp --");

    }

    @org.junit.Test
    public void testPenDown() throws Exception {
        System.out.println("-- testPenDown --");

    }

    @org.junit.Test
    public void testIsPenUp() throws Exception {
        System.out.println("-- testIsPenUp --");

    }

    @org.junit.Test
    public void testDirection() throws Exception {
        System.out.println("-- testDirection --");

    }

    @org.junit.Test
    public void testLocation() throws Exception {
        System.out.println("-- testLocation --");

    }
}