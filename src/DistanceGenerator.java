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
        DistanceGenerator repeatGenerator = new DistanceGenerator(distanceTurtle);
        distance += repeatGenerator.visit(repeatNodes);
    }

    @Override
    public void visitTurnNode(Turn aNode) {

    }

    @Override
    public void visitVariableNode(Variable aNode) {
        aNode.evaluate(distanceTurtle);
    }
}
