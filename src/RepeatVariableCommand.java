import java.util.List;

/**
 * Created by cxj8923 on 4/13/15.
 */
public class RepeatVariableCommand implements Command
{
    private Turtle subject;
    private String variable;
    private List<Command> commands;

    public RepeatVariableCommand(Turtle commandTurtle, String countVariable, List<Command> repeatCommands)
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
            for(Command command : commands)
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
            for(Command command : commands)
            {
                command.undo();
            }
        }

    }
}
