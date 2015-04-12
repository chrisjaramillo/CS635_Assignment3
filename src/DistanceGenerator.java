import java.util.List;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class DistanceGenerator implements TurtleGenerator{
    Turtle distanceTurtle;
    int distance;

    DistanceGenerator(Turtle aTurtle)
    {
        distanceTurtle = aTurtle;
    }

    public int visit(List<TurtleNode> nodeList)
    {
        for(TurtleNode node : nodeList)
        {
            node.accept(this);
        }
        return distance;
    }
    @Override
    public void visitConstantNode(Constant aNode) {

    }

    @Override
    public void visitLookupVariableNode(LookupVariable aNode) {

    }

    @Override
    public void visitMoveNode(Move aNode) {
        TurtleNode distanceNode = aNode.getDistance();
        if(distanceNode instanceof Constant)
        {
            distance += ((Constant)distanceNode).getValue();
        }
        else if(distanceNode instanceof LookupVariable)
        {
            distance += distanceTurtle.getVariable(((LookupVariable)distanceNode).getVariableName());
        }
        distance += aNode.evaluate(distanceTurtle);
    }

    @Override
    public void visitPenDownNode(PenDown aNode) {

    }

    @Override
    public void visitPenUpNode(PenUp aNode) {

    }

    @Override
    public void visitRepeatNode(Repeat aNode) {
        List<TurtleNode> repeatNodes = aNode.getList();
        int count = 0;
        TurtleNode countNode;
        countNode = aNode.getRepetitions();
        if(countNode instanceof  Constant)
        {
            count = ((Constant)countNode).getValue();
        }
        else if(countNode instanceof LookupVariable)
        {
            count = distanceTurtle.getVariable(((LookupVariable)countNode).getVariableName());
        }
        DistanceGenerator repeatGenerator;
        for(int i=0; i<count; i++)
        {
            repeatGenerator = new DistanceGenerator(distanceTurtle);
            distance += repeatGenerator.visit(repeatNodes);
        }
    }

    @Override
    public void visitTurnNode(Turn aNode) {

    }

    @Override
    public void visitVariableNode(Variable aNode) {
        TurtleNode valueNode = aNode.getValue();
        int value = 0;
        if(valueNode instanceof Constant)
        {
            value = ((Constant)valueNode).getValue();
        }
        else if(valueNode instanceof LookupVariable)
        {
            value = distanceTurtle.getVariable(((LookupVariable)valueNode).getVariableName());
        }
        distanceTurtle.setVariables(aNode.name, value);
    }
}
