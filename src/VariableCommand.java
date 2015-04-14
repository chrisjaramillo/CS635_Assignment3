/**
 * Created by Christopher Jaramillo on 4/13/15.
 */
public class VariableCommand implements TurtleCommand
{
    private Turtle subject;
    private String name;
    private int value;

    VariableCommand(Turtle variableHolder, String variableName, int variableValue)
    {
        subject = variableHolder;
        name = variableName;
        value = variableValue;
    }

    @Override
    public void execute()
    {
        subject.setVariables(name, value);
    }

    @Override
    public void undo()
    {

    }
}
