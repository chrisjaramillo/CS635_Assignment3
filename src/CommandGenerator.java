import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class CommandGenerator implements TurtleGenerator {
    Turtle commandTurtle;
    List<Command> commandList;
    public CommandGenerator(Turtle aTurtle)
    {
        commandTurtle = aTurtle;
        commandList = new ArrayList<Command>();
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
    public void visitConstantNode(Constant aNode) {

    }

    @Override
    public void visitLookupVariableNode(LookupVariable aNode) {

    }

    @Override
    public void visitMoveNode(Move aNode) {
        commandList.add(new MoveCommand(commandTurtle, aNode.evaluate(commandTurtle)));

    }

    @Override
    public void visitPenDownNode(PenDown aNode) {
        commandList.add(new PenDownCommand(commandTurtle));

    }

    @Override
    public void visitPenUpNode(PenUp aNode) {
        commandList.add(new PenUpCommand(commandTurtle));
    }

    @Override
    public void visitRepeatNode(Repeat aNode) {
        this.visit(aNode.getList());
    }

    @Override
    public void visitTurnNode(Turn aNode) {
        commandList.add(new TurnCommand(commandTurtle, aNode.evaluate(commandTurtle)));

    }

    @Override
    public void visitVariableNode(Variable aNode) {
        aNode.evaluate(commandTurtle);
    }
}
