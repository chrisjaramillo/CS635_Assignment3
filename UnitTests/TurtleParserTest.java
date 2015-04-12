import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class TurtleParserTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter writer = new PrintWriter("testParser.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move 10");
        writer.println("turn 90");
        writer.println("penDown");
        writer.close();

        writer = new PrintWriter("testParser1.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move $length");
        writer.close();

        writer = new PrintWriter("testParser2.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move $length");
        writer.close();
    }

    @After
    public void tearDown() throws Exception {
        File file = new File("testParser.txt");
        file.delete();
        file = new File("testParser1.txt");
        file.delete();
        file = new File("testParser2.txt");
        file.delete();
    }

    @Test
    public void testParse() throws Exception {

    }
}