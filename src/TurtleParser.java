import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class TurtleParser {
    public List<TurtleNode> parse(String filename) throws FileNotFoundException, IOException
    {
        BufferedReader programFile = new BufferedReader(new FileReader(filename));
        List<TurtleNode> parsedProgram = new LinkedList<>();
        String line;
        while((line = programFile.readLine()) != null)
        {
            TurtleNode convertedLine = this.convertLine(line, programFile);
        }
        return parsedProgram;

    }

    private TurtleNode convertLine(String line,BufferedReader reader) throws IOException
    {
        TurtleNode interpreterNode = null;
        String[] tokens = line.split("\\s");
        if(tokens[0].equals("penUp"))
        {
            interpreterNode = new PenUp();
        }
        else if(tokens[0].equals("penDown"))
        {
            interpreterNode = new PenDown();
        }
        else if(tokens[0].equals("move"))
        {
            TurtleNode distance;
            if(tokens[1].charAt(0) == '$')
                distance = new LookupVariable(tokens[1]);
            else
                distance = new Constant(tokens[1]);
            interpreterNode = new Move(distance);
        }
        else if(tokens[0].equals("turn"))
        {
            TurtleNode angle;
            if(tokens[1].charAt(0) == '$')
                angle = new LookupVariable(tokens[1]);
            else
                angle = new Constant(tokens[1]);
            interpreterNode = new Turn(angle);
        }
        else if(tokens[0].equals("repeat")) {
            TurtleNode repetitions;
            if(tokens[1].charAt(0) == '$')
                repetitions = new LookupVariable(tokens[1]);
            else
                repetitions = new Constant(tokens[1]);
            interpreterNode = new Repeat(repetitions);
            convertRepeatBlock((Repeat)interpreterNode, reader);
        }
        else if(tokens[0].charAt(0) == '$')
        {
            TurtleNode value;
            if(tokens[2].charAt(0) == '$')
                value = new LookupVariable(tokens[2]);
            else
                value = new Constant(tokens[2]);
            interpreterNode = new Variable(tokens[0], value);
        }
        return interpreterNode;
    }

    private void convertRepeatBlock(Repeat aRepeatNode, BufferedReader aReader) throws IOException
    {
        String line;
        while(!(line = aReader.readLine()).equals("end"))
        {
            TurtleNode convertedLine = this.convertLine(line, aReader);
            aRepeatNode.addNode(convertedLine);
        }
    }
}
