/**
 * Created by cxj8923 on 4/13/15.
 */
public class VariableCommand implements Command
{
    private Turtle subject;
    private String name;
    private int value;
    private int oldValue;

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
