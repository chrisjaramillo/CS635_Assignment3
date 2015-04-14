/**
 * Created by Christopher Jaramillo on 4/11/15.
 */
public class PenUpCommand implements TurtleCommand
{

    private Turtle subject;
    public PenUpCommand(Turtle toPenUp)
    {
        subject = toPenUp;
    }

    public void execute() {
        subject.penUp();
    }

    public void undo()
    {
        subject.penDown();
    }
}
