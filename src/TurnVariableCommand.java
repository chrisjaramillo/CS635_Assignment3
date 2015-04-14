/**
 * Created by Christopher Jaramillo on 4/13/15.
 */
public class TurnVariableCommand implements Command
{
    private String variableName;
    private Turtle subject;

    TurnVariableCommand(Turtle toTurn, String variable)
    {
        variableName = variable;
        subject = toTurn;
    }

    @Override
    public void execute()
    {
        int turnDegrees = subject.getVariable(variableName);
        subject.turn(turnDegrees);
    }

    @Override
    public void undo()
    {
        int turnDegrees = subject.getVariable(variableName);
        subject.turn(turnDegrees * -1);
    }
}
