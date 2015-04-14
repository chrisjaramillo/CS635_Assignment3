/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class Constant implements TurtleNode
{
    private int value;

    public Constant(String aValue)
    {
        value = Integer.valueOf(aValue);
    }

    @Override
    public int evaluate(Turtle values)
    {
        return value;
    }

    public void accept(TurtleGenerator aVisitor)
    {
        aVisitor.visitConstantNode(this);
    }

    public int getValue() {
        return value;
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
