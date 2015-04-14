/**
 * Created by Christopher Jaramillo on 4/10/15.
 */
public interface TurtleNode
{
    public int evaluate(Turtle values);
    public String toString();
    public void accept(TurtleGenerator generator);
}
