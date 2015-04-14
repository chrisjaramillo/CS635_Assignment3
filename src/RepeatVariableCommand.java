import java.util.List;

/**
 * Created by Christopher Jaramillo on 4/13/15.
 */
public class RepeatVariableCommand implements TurtleCommand
{
    private Turtle subject;
    private String variable;
    private List<TurtleCommand> commands;

    public RepeatVariableCommand(Turtle commandTurtle, String countVariable, List<TurtleCommand> repeatCommands)
    {
        subject = commandTurtle;
        variable = countVariable;
        commands = repeatCommands;
    }

    @Override
    public void execute()
    {
        for(int i=0; i<subject.getVariable(variable); i++)
        {
            for(TurtleCommand command : commands)
            {
                command.execute();
            }
        }
    }

    @Override
    public void undo()
    {
        for(int i=0; i<subject.getVariable(variable); i++)
        {
            for(TurtleCommand command : commands)
            {
                command.undo();
            }
        }

    }
}
