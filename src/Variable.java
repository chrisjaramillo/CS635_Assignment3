/**
 * Created by cxj8923 on 4/10/15.
 */
public class Variable implements TurtleNode{
    String name;
    int value;
    Variable(String aName, String aValue)
    {
        name = aName;
        value = Integer.valueOf(aValue);
    }
    @Override
    public int evaluate(Turtle values)
    {
        values.setVariables(name, value);
        return 0;
    }

    @Override
    public void accept(TurtleGenerator generator) {
        generator.visitVariableNode(this);
    }

}
