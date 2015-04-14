import java.io.*;
import java.util.List;

/**
 * Created by cxj8923 on 4/13/15.
 */
public class Assignment3 {
    public static void main(String[] args) throws IOException {
        Turtle aTurtle = new Turtle();
        TurtleParser aParser = new TurtleParser();
        PrintWriter writer = new PrintWriter("testParser.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("move $length");
        writer.println("turn $length");
        writer.println("penUp");
        writer.close();

        List<TurtleNode> aList = aParser.parse("testParser.txt");
        for(TurtleNode node : aList)
        {
            node.evaluate(aTurtle);
        }
        System.out.println(aList);
        System.out.println(aTurtle.location());
        System.out.println(aTurtle.direction());


        File file = new File("testParser.txt");
        file.delete();

        writer = new PrintWriter("testParser.txt", "UTF-8");
        writer.println("$length = 10");
        writer.println("penDown");
        writer.println("repeat $length");
        writer.println("move $length");
        writer.println("end");
        writer.println("$length = 5");
        writer.println("repeat $length");
        writer.println("turn $length");
        writer.println("end");
        writer.println("penUp");
        writer.close();

        DistanceGenerator aGenerator = new DistanceGenerator();
        aParser = new TurtleParser();
        aList = aParser.parse("testParser.txt");
        int distance = aGenerator.visit(aList);
        System.out.println(distance);

        aTurtle = new Turtle();
        CommandGenerator commandGenerator = new CommandGenerator(aTurtle);
        List<TurtleCommand> commandList = commandGenerator.visit(aList);
        System.out.println(commandList);
        for(TurtleCommand command : commandList)
        {
            command.execute();
        }
        System.out.println(commandList);
        System.out.println(aTurtle.location());
        System.out.println(aTurtle.direction());
        file = new File("testParser.txt");
        file.delete();


    }
}
