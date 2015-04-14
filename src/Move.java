/**
 * Created by Christopher Jaramillo on 4/10/15.
 */
public class Move implements TurtleNode
{
    TurtleNode distance;

    public Move(TurtleNode aNode)
    {
        distance = aNode;
    }

    @Override
    public int evaluate(Turtle values)
    {
        int toMove = distance.evaluate(values);
        values.move(toMove);
        return toMove;
    }

    @Override
    public void accept(TurtleGenerator generator)
    {
        generator.visitMoveNode(this);
    }

    public TurtleNode getDistance()
    {
        return distance;
    }

    public String toString()
    {
        return "move " + distance.toString() + System.getProperty("line.separator");
    }
}