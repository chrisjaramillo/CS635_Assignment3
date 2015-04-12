/**
 * Created by cxj8923 on 4/10/15.
 */
public class PenUp implements TurtleNode{

    @Override
    public int evaluate(Turtle values)
    {
        values.penUp();
        return 0;
    }

    @Override
    public void accept(TurtleGenerator generator) {
        generator.visitPenUpNode(this);
    }
}
