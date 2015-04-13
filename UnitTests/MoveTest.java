import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class MoveTest {
    private Turtle testTurtle;
    private TurtleNode constant;
    private  TurtleNode variable;

    @org.junit.Before
    public void setUp()
    {
        testTurtle = new Turtle();
        testTurtle.setVariables("$K",5);
        constant = new Constant("5");
        variable = new LookupVariable("$K");
    }

    @Test
    public void testEvaluateConstant() throws Exception
    {
        TurtleNode moveNode = new Move(constant);
        int moveValue = moveNode.evaluate(testTurtle);
        assertEquals("Value moved is not 5", 5, moveValue);
        Point2D p = testTurtle.location();
        assertEquals("Turtle x is not 5", 5.0, p.getX(), .001);
    }

    @Test
    public void testEvaluateVariable() throws Exception
    {
        TurtleNode moveNode = new Move(variable);
        int moveValue = moveNode.evaluate(testTurtle);
        assertEquals("Value moved is not 5", 5, moveValue);
        Point2D p = testTurtle.location();
        assertEquals("Turtle x is not 5", 5.0, p.getX(), .001);
    }
}