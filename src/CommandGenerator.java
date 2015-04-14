import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class CommandGenerator implements TurtleGenerator {
    private Turtle commandTurtle;
    private List<TurtleCommand> commandList;
    private HashMap<String, Integer> variables;

    public CommandGenerator(Turtle aTurtle)
    {
        commandTurtle = aTurtle;
        commandList = new ArrayList<TurtleCommand>();
        variables = new HashMap<String, Integer>();
    }

    public List<TurtleCommand> visit(List<TurtleNode> nodeList)
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
        CommandGenerator repeatGenerator = new CommandGenerator(commandTurtle);
        List<TurtleCommand> repeatCommands = repeatGenerator.visit(aNode.getList());
        TurtleNode countNode = aNode.getRepetitions();
        if(countNode instanceof Constant)
        {
            int count = 0;
            count = ((Constant)countNode).getValue();
            commandList.add(new RepeatConstantCommand(commandTurtle, count, repeatCommands));
        }
        else if(countNode instanceof LookupVariable)
        {
            String countVariable = ((LookupVariable)countNode).getVariableName();
            commandList.add(new RepeatVariableCommand(commandTurtle, countVariable, repeatCommands));
        }
    }

    @Override
    public void visitTurnNode(Turn aNode)
    {
        TurtleNode degreesNode = aNode.getDegrees();
        if(degreesNode instanceof Constant)
        {
            int degrees = 0;
            degrees = ((Constant)degreesNode).getValue();
            commandList.add(new TurnConstantCommand(commandTurtle, degrees));
        }
        else if(degreesNode instanceof LookupVariable)
        {
            String turnVariable = ((LookupVariable)degreesNode).getVariableName();
            commandList.add(new TurnVariableCommand(commandTurtle, turnVariable));
        }
    }

    @Override
    public void visitVariableNode(Variable aNode)
    {
        int value = 0;
        TurtleNode valueNode = aNode.getValue();
        if(valueNode instanceof  Constant)
        value = ((Constant)valueNode).getValue();
        commandList.add(new VariableCommand(commandTurtle, aNode.getName(), value));
    }
}