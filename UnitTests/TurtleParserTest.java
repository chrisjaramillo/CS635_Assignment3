import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class TurtleParserTest {

    @Before
    public void setUp() throws Exception
    {
        PrintWriter writer = new PrintWriter("testParser.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move 12");
        writer.println("turn 90");
        writer.println("penUp");
        writer.close();

        writer = new PrintWriter("testParser1.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move $length");
        writer.close();

        writer = new PrintWriter("testParser2.txt", "UTF-8");
        writer.println("penDown");
        writer.println("repeat 2");
        writer.println("penDown");
        writer.println("move 10");
        writer.println("end");
        writer.close();
    }

    @After
    public void tearDown() throws Exception
    {
        File file = new File("testParser.txt");
        file.delete();
        file = new File("testParser1.txt");
        file.delete();
        file = new File("testParser2.txt");
        file.delete();
    }

    @Test
    public void testParse() throws Exception
    {
        TurtleParser testParser = new TurtleParser();
        List<TurtleNode> testList = testParser.parse("testParser.txt");
        assertEquals("There are not 5 nodes", 5, testList.size());
        ListIterator<TurtleNode> testIterator = testList.listIterator();
        TurtleNode testNode = testIterator.next();
        assertTrue(testNode instanceof Variable);
        assertFalse(testNode instanceof Move);
        assertEquals("Variable name is not $length", "$length", ((Variable) testNode).getName());
        testNode = ((Variable) testNode).getValue();
        assertTrue(testNode instanceof Constant);
        assertEquals("Variable value is not 10", 10, ((Constant) testNode).getValue());
        testNode = testIterator.next();
        assertTrue(testNode instanceof PenDown);
        testNode = testIterator.next();
        assertTrue(testNode instanceof Move);
        testNode = ((Move) testNode).getDistance();
        assertTrue(testNode instanceof Constant);
        assertEquals("Move value is not 12", 12, ((Constant) testNode).getValue());
        testNode = testIterator.next();
        assertTrue(testNode instanceof Turn);
        testNode = ((Turn)testNode).getDegrees();
        assertTrue(testNode instanceof Constant);
        testNode = testIterator.next();
        assertTrue(testNode instanceof PenUp);
    }
}