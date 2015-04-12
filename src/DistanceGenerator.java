import java.util.HashMap;
import java.util.List;

/**
 * Created by cxj8923 on 4/11/15.
 */
public class DistanceGenerator implements TurtleGenerator{

    int distance;
    private HashMap<String, Integer> variables;

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
        distance += getValue(distanceNode);
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
        count = getValue(countNode);
        for(int i=0; i<count; i++)
        {
            this.visit(repeatNodes);
        }
    }

    @Override
    public void visitTurnNode(Turn aNode) {

    }

    @Override
    public void visitVariableNode(Variable aNode) {
        TurtleNode valueNode = aNode.getValue();
        int value = 0;
        value = getValue(valueNode);
        variables.put(aNode.getName(),value);
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
            value = variables.get(((LookupVariable) valueNode).getVariableName());
        }
        return value;
    }
}
