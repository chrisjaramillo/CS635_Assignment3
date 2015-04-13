import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class MoveTest {

    @org.junit.Before
    public void setUp()
    {
        Turtle testTurtle = new Turtle();
        testTurtle.setVariables("$K",5);
        TurtleNode constant = new Constant("5");
        TurtleNode variable = new LookupVariable("$K");
    }
    @Test
    public void testEvaluateConstant() throws Exception
    {

    }
}