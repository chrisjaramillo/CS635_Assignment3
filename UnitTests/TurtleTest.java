import java.awt.geom.Point2D;

import static org.junit.Assert.*;

/**
 * Created by Christopher on 4/8/2015.
 */
public class TurtleTest {

    @org.junit.Before
    public void setUp() throws Exception
    {
        System.out.println("-- setUp --");

    }

    @org.junit.Test
    public void testConstruction() throws Exception
    {
        System.out.println("-- testConstruction --");
        Turtle t = null;
        assertEquals("Turtle not null before instantiation", null, t);
        t = new Turtle();
        assertNotEquals("Turtle null after instantiation", null, t);
    }

    @org.junit.Test
    public void testMoveZero() throws Exception
    {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        Point2D p = t.location();
        double x = p.getX();
        double y = p.getY();
        t.move(0);
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertEquals("Starting point and end point are equal after move.", x1, 0.0, .001);
        assertEquals("Starting point and end point are equal after move.", y1, 0.0, .001);
    }

    @org.junit.Test
    public void testMoveX() throws Exception
    {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        Point2D p = t.location();
        double x = p.getX();
        double y = p.getY();
        t.move(1);
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertNotEquals("Starting point and end point are equal after move.", x, x1, .001);
        assertEquals("Starting point and end point are equal after move.", y, y1, .001);
    }

    @org.junit.Test
    public void testMovNegativeX() throws Exception
    {
        System.out.println("-- testMovNegativeX --");
        Turtle t = new Turtle();
        t.turn(180);
        t.move(1);
        Point2D p;
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertEquals("Starting point and end point are equal after move.", x1, -1.0, .001);
        assertEquals("Starting point and end point are equal after move.", y1, 0.0, .001);
    }

    @org.junit.Test
    public void testMoveY() throws Exception
    {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        t.turn(90);
        Point2D p = t.location();
        double x = p.getX();
        double y = p.getY();
        t.move(1);
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertEquals("Starting point and end point are equal after move.", x, x1, .001);
        assertEquals("Starting point and end point are equal after move.", x1, 0.0, .001);
        assertEquals("Starting point and end point are equal after move.", y1, 1.0, .001);
        assertNotEquals("Starting point and end point are equal after move.", y, y1, .001);
    }

    @org.junit.Test
    public void testMoveNegativeY() throws Exception
    {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        t.turn(270);
        Point2D p = t.location();
        double x = p.getX();
        double y = p.getY();
        t.move(1);
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertEquals("Starting point and end point are equal after move.", x, x1, .001);
        assertEquals("Starting point and end point are equal after move.", 0.0, x1, .001);
        assertEquals("Starting point and end point are equal after move.", -1.0, y1, .001);
        assertNotEquals("Starting point and end point are equal after move.", y, y1, .001);
    }

    @org.junit.Test
    public void testMoveXY() throws Exception
    {
        System.out.println("-- testMove --");
        Turtle t = new Turtle();
        t.turn(45);
        Point2D p = t.location();
        double x = p.getX();
        double y = p.getY();
        t.move(1);
        p = t.location();
        double x1 = p.getX();
        double y1 = p.getY();
        assertNotEquals("Starting point and end point are equal after move.", x, x1, .001);
        assertNotEquals("Starting point and end point are equal after move.", y, y1, .001);
    }

    @org.junit.Test
    public void testTurn() throws Exception
    {
        System.out.println("-- testTurn --");
        Turtle t = new Turtle();
        assertEquals("Starting direction is not 0.", 0, t.direction());
        t.turn(10);
        assertEquals("End direction is not 10 after turn.", 10, t.direction());
        t.turn(351);
        assertEquals("End direction is not 1 after turn.", 1, t.direction());
    }

    @org.junit.Test
    public void testPenUp() throws Exception
    {
        System.out.println("-- testPenUp --");
        Turtle t = new Turtle();
        t.penUp();
        assertTrue("Pen is not up",t.isPenUp());

    }

    @org.junit.Test
    public void testPenDown() throws Exception
    {
        System.out.println("-- testPenDown --");
        Turtle t = new Turtle();
        t.penDown();
        assertFalse("Pen is not down", t.isPenUp());
    }
}