/**
 * Created by cxj8923 on 4/10/15.
 */
public class Turn implements TurtleNode {
    TurtleNode degrees;

    public Turn(TurtleNode aNode)
    {
        degrees = aNode;
    }

    @Override
    public int evaluate(Turtle values)
    {
        int turnDegrees = degrees.evaluate(values);
        values.turn(turnDegrees);
        return turnDegrees;
    }

    @Override
    public void accept(TurtleGenerator generator)
    {
        generator.visitTurnNode(this);
    }


    public TurtleNode getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return "turn " + degrees.toString();
    }
}
