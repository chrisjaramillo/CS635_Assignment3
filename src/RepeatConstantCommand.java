import java.util.List;

/**
 * Created by cxj8923 on 4/13/15.
 */
public class RepeatConstantCommand implements Command
{
    private List<Command> commands;
    private Turtle subject;
    private int repetitions;

    RepeatConstantCommand(Turtle toRepeat, int count, List<Command> commands)
    {
        subject = toRepeat;
        repetitions = count;
        this.commands = commands;
    }

    @Override
    public void execute()
    {
        for(int i=0; i<repetitions; i++)
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
        for(int i=0; i<repetitions; i++)
        {
            for(Command command : commands)
            {
                command.undo();
            }
        }
    }
}
