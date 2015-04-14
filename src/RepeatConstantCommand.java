import java.util.List;

/**
 * Created by Christopher Jaramillo on 4/13/15.
 */
public class RepeatConstantCommand implements TurtleCommand
{
    private List<TurtleCommand> commands;
    private Turtle subject;
    private int repetitions;

    RepeatConstantCommand(Turtle toRepeat, int count, List<TurtleCommand> commands)
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
            for(TurtleCommand command : commands)
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
            for(TurtleCommand command : commands)
            {
                command.undo();
            }
        }
    }
}
