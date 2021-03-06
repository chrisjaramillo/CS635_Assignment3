/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class LookupVariable implements TurtleNode
{
    String variableName;

    public LookupVariable(String aName)
    {
        variableName = aName;
    }

    @Override
    public int evaluate(Turtle values)
    {
        return values.getVariable(variableName);
    }

    @Override
    public void accept(TurtleGenerator generator)
    {
        generator.visitLookupVariableNode(this);
    }

    public String getVariableName()
    {
        return variableName;
    }

    public String toString()
    {
        return variableName;
    }
}
