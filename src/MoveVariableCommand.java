/**
 * Created by cxj8923 on 4/12/15.
 */
public class MoveVariableCommand implements Command
{
    private Turtle variableMove;
    private String variableName;

    public MoveVariableCommand(Turtle toMove, String aVariableName)
    {
        variableMove = toMove;
        variableName = aVariableName;
    }

    @Override
    public void execute()
    {
        int distance = variableMove.getVariable(variableName);
        variableMove.move(distance);
    }

    @Override
    public void undo() {

    }
}
