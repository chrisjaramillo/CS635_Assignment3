/**
 * Created by cxj8923 on 4/10/15.
 */
public class Variable implements TurtleNode{
    String name;
    TurtleNode valueNode;
    Variable(String aName, TurtleNode aNode)
    {
        name = aName;
        valueNode = aNode;
    }
    @Override
    public int evaluate(Turtle values)
    {
        int value = valueNode.evaluate(values);
        values.setVariables(name, value);
        return 0;
    }

    @Override
    public void accept(TurtleGenerator generator) {
        generator.visitVariableNode(this);
    }

    public String getName() {
        return name;
    }

    public TurtleNode getValue() {
        return valueNode;
    }

    @Override
    public String toString() {
        return name + " = " + valueNode.toString()  + System.getProperty("line.separator");
    }
}
