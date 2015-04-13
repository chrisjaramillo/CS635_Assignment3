import org.junit.Assert;
import org.junit.Test;

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
        assertEquals("Value moved is not 5", 5, );
    }
}