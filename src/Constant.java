/**
 * Created by cxj8923 on 4/11/15.
 */
public class Constant implements TurtleNode {
    int value;

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
}
