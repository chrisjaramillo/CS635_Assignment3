import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class CommandGenerator implements TurtleGenerator {
    private Turtle commandTurtle;
    private List<Command> commandList;
    private HashMap<String, Integer> variables;

    public CommandGenerator(Turtle aTurtle)
    {
        commandTurtle = aTurtle;
        commandList = new ArrayList<Command>();
        variables = new HashMap<String, Integer>();
    }

    public List<Command> visit(List<TurtleNode> nodeList)
    {
        for(TurtleNode node : nodeList)
        {
            node.accept(this);
        }
        return commandList;
    }

    @Override
    public void visitConstantNode(Constant aNode)
    {

    }

    @Override
    public void visitLookupVariableNode(LookupVariable aNode)
    {

    }

    @Override
    public void visitMoveNode(Move aNode)
    {
        TurtleNode distanceNode = aNode.getDistance();
        if(distanceNode instanceof Constant)
        {
            int distance = ((Constant)distanceNode).getValue();
            commandList.add(new MoveConstantCommand(commandTurtle, distance));
        }
        else if(distanceNode instanceof LookupVariable)
        {
            String variableName = ((LookupVariable)distanceNode).getVariableName();
            commandList.add(new MoveVariableCommand(commandTurtle, variableName));
        }
    }

    @Override
    public void visitPenDownNode(PenDown aNode)
    {
        commandList.add(new PenDownCommand(commandTurtle));
    }

    @Override
    public void visitPenUpNode(PenUp aNode)
    {
        commandList.add(new PenUpCommand(commandTurtle));
    }

    @Override
    public void visitRepeatNode(Repeat aNode)
    {
        int count = 0;
        TurtleNode countNode = aNode.getRepetitions();
        count = getValue(countNode);
        for(int i=0; i<count; i++)
        {
            this.visit(aNode.getList());
        }
    }

    @Override
    public void visitTurnNode(Turn aNode)
    {
        int degrees = 0;
        TurtleNode degreesNode = aNode.getDegrees();
        degrees = getValue(degreesNode);
        commandList.add(new TurnCommand(commandTurtle, degrees));
    }

    @Override
    public void visitVariableNode(Variable aNode)
    {
        int value = 0;
        TurtleNode valueNode = aNode.getValue();
        value = getValue(valueNode);
        variables.put(aNode.getName(), value);
    }

    private int getValue(TurtleNode valueNode)
    {
        int value = 0;
        if(valueNode instanceof  Constant)
        {
            value = ((Constant)valueNode).getValue();
        }
        else if(valueNode instanceof LookupVariable)
        {
            value = variables.get(((LookupVariable)valueNode).getVariableName());
        }
        return value;
    }
}