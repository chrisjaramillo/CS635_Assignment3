/**
 * Created by cxj8923 on 4/10/15.
 */
public class PenDown implements TurtleNode{
    @Override
    public int evaluate(Turtle values)
    {
        values.penDown();
        return 0;
    }

    @Override
    public void accept(TurtleGenerator generator) {
        generator.visitPenDownNode(this);
    }

    public String toString()
    {
        return "penDown"  + System.getProperty("line.separator");
    }
}
